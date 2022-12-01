/*
 * Main logic for the game
 */

package legendsofvalor;

import java.util.ArrayList;


import legendsofvalor.utils.ColorPrint;
import legendsofvalor.utils.ConfigurationAdaptor;
import legendsofvalor.utils.GameAI;
import legendsofvalor.utils.GameUtils;
import legendsofvalor.utils.UserInput;
import legendsofvalor.view.HeroView;
import legendsofvalor.world.WorldMap;
import legendsofvalor.world.Position;
import legendsofvalor.character.Hero;
import legendsofvalor.character.Monster;
import legendsofvalor.character.MonsterFactory;

public class GamePlatform {


    private void initTeam(ArrayList<Hero> all_heroes, int lane) {
        while (true) {
            int index = UserInput.getInstance().getChoice(1, all_heroes.size());
            if (WorldMap.getInstance().getHeroes().contains(all_heroes.get(index))) {
                ColorPrint.error("You have already selected this hero. Please enter a valid index:");
                continue;
            }
            Hero curHero = all_heroes.get(index - 1);
            Position position = WorldMap.getInstance().getHeroInitPosition(lane);
            curHero.setRevivePosition(position);
            WorldMap.getInstance().register(curHero, position);

            return;
        }
    }

    private void generateMonsters() {
        ArrayList<Hero> heroes = WorldMap.getInstance().getHeroes();
        int highestLevel = 0;
        for (Hero hero : heroes) {
            if (hero.getLevel().get() > highestLevel) {
                highestLevel = hero.getLevel().get();
            }
        }
        for (int i = 0; i < 3; i++) {
            Monster monster = MonsterFactory.create(highestLevel);
            Position position = WorldMap.getInstance().getMonsterInitPosition(i);
            WorldMap.getInstance().register(monster, position);
        }
    }


    public void startGame() {
        // print welcome message
        ColorPrint.green("Welcome to Legends: Monsters and Heroes!");
        // load configuration using adaptor
        ColorPrint.plain("Loading configuration...");
        ConfigurationAdaptor adaptor = ConfigurationAdaptor.getInstance();
        ColorPrint.plain("Done!");
        // show all heroes
        ColorPrint.green("Here are all the heroes:");
        ArrayList<Hero> all_heroes = adaptor.getHeroes();
        ColorPrint.plain(GameUtils.getCharacterTableAll(all_heroes));
        // select 3 heroes
        ColorPrint.info("You need to select 3 characters to play with.");
        for (int i = 0; i < 3; i++) {
            ColorPrint.query("Please select a hero for lane " + (i + 1) + " using numbers:");
            initTeam(all_heroes, i);
        }
        System.out.println(GameUtils.getCharacterTable(WorldMap.getInstance().getHeroes()));
        ColorPrint.green("Your team of heroes if complete! Good luck on your quest!");
        // Game begins

        int gameResult = 0;

        for (int R = 0; gameResult == 0; R++) {
            // generate monsters every 8 rounds
            if (R % 8 == 0) {
                generateMonsters();
            }
            // print the map
            System.out.println(WorldMap.getInstance());
            // hero's turn
            ArrayList<Hero> heros = WorldMap.getInstance().getHeroes();
            for (int i = 0; i < heros.size(); i++) {
                // do hero's turn
                Hero curHero = heros.get(i);
                ColorPrint.green("[Hero] " + curHero.getName().get() + "'s turn");
                HeroView.view(curHero);
                // print the map
                System.out.println(WorldMap.getInstance());
                // check win
                if ((gameResult = WorldMap.getInstance().checkWin()) != 0) {
                    break;
                }
            }
            // check win
            if (gameResult != 0) {
                break;
            }
            // monster's turn
            ArrayList<Monster> monsters = WorldMap.getInstance().getMonsters();
            for (int i = 0; i < monsters.size(); i++) {
                Monster curMonster = WorldMap.getInstance().getMonsters().get(i);
                ColorPrint.green("[Monster] " + curMonster.getName().get() + "'s turn");
                GameAI.MonsterAI(curMonster);
                // check win
                if ((gameResult = WorldMap.getInstance().checkWin()) != 0) {
                    break;
                }
            }
            ColorPrint.plain("A round ends. Press enter to continue...");
            UserInput.getInstance().getNextline();
        }
        if (gameResult == 1) {
            ColorPrint.green("Congratulations! You have won the game!");
        } else {
            ColorPrint.red("You have lost the game! Game over!");
        }

    }
}
