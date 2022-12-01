package legendsofvalor.view;

import java.util.ArrayList;

import legendsofvalor.character.Hero;
import legendsofvalor.character.Monster;
import legendsofvalor.utils.ColorPrint;
import legendsofvalor.utils.GameUtils;
import legendsofvalor.utils.UserInput;
import legendsofvalor.world.WorldMap;

public class AttackView {
    private static void reward(Monster monter) {
        int goldReward = monter.getLevel().get() * 500;
        int expReward = monter.getLevel().get() * 2;
        ColorPrint.green("All heroes earned " + goldReward + " gold and " + expReward + " experience");
        ArrayList<Hero> heroes = WorldMap.getInstance().getHeroes();
        for (Hero hero : heroes) {
            hero.getGold().increase(goldReward);
            hero.getExperience().increase(expReward);
            hero.checkLevelUp();
        }
    }


    public static boolean view(Hero hero) {
        ArrayList<Monster> monsters = WorldMap.getInstance().getAttackScope(hero);
        if (monsters.size() == 0) {
            ColorPrint.error("No monster in attack scope");
            return false;
        }
        ColorPrint.info("Please choose a monster to attac, or enter [0] to cancel and go back:");
        ColorPrint.plain(GameUtils.getCharacterTable(monsters));
        int index = UserInput.getInstance().getChoice(1, monsters.size());
        if (index == 0) {
            return false;
        }
        Monster curMonster = monsters.get(index - 1);
        String result = hero.attack(curMonster);
        ColorPrint.info(result);
        if (curMonster.getHP().get() <= 0) {
            WorldMap.getInstance().removeMonster(curMonster);
            ColorPrint.info("You have killed the monster successfully.");
            reward(curMonster);
        }
        return true;
    }

}