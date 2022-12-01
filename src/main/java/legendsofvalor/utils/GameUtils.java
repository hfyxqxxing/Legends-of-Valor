/*
 * Utils that widely used in the game
 */
package legendsofvalor.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import legendsofvalor.character.Character;
import legendsofvalor.character.Hero;
import legendsofvalor.character.Monster;
import legendsofvalor.world.WorldMap;

public class GameUtils {
    // print table of items with number
    public static String getNiceTable(String header, ArrayList<String> rows) {
        String re = "";
        re += "     " + header + "\n" + "     " + String.join("", Collections.nCopies(header.length(), "-")) + "\n";
        for (int i = 0; i < rows.size(); i++) {
            re += String.format("%-5s", "[" + (i + 1) + "]") + rows.get(i) + "\n";
        }
        return re;
    }

    // print table of heroes or monsters
    public static String getCharacterTable(ArrayList<? extends Character> characters) {
        ArrayList<String> rows = new ArrayList<>();
        for (int i = 0; i < characters.size(); i++) {
            rows.add(characters.get(i).getBody());
        }
        return getNiceTable(characters.get(0).getHeader(), rows);
    }

    // print table of single hero or monster
    public static <T extends Character> String getCharacterTable(T character) {
        ArrayList<T> temp = new ArrayList<T>();
        temp.add(character);
        return GameUtils.getCharacterTable(temp);
    }


    // selector for both heroes and monsters
    public static <T extends Character> T selectCharacter(Scanner sc, ArrayList<T> characters) {
        ColorPrint.plain(getCharacterTable(characters));
        int index = UserInput.getInstance().getChoice(1, characters.size());
        return characters.get(index);
    }

    public static void reward(Monster monter) {
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

}
