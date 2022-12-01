/*
 * This class automatic operate the monster to fight against the hero
 */
package legendsofvalor.utils;

import java.util.ArrayList;

import legendsofvalor.character.Hero;
import legendsofvalor.character.Monster;
import legendsofvalor.world.Position;
import legendsofvalor.world.WorldMap;

public class GameAI {
    public static void MonsterAI(Monster monster) {
        ArrayList<Hero> heroes = WorldMap.getInstance().getAttackScope(monster);
        // if no hero can be attact, try move down
        if (heroes.size() == 0) {
            Position position = WorldMap.getInstance().canMoveDown(monster);
            WorldMap.getInstance().moveTo(monster, position);
            return;
        }
        // otherwise, do attact to first hero
        Hero hero = heroes.get(0);
        String result = monster.attack(hero);
        System.out.println(result);
        // if hero is dead, send back to nuxes
        if (hero.getHP().get() <= 0) {
            WorldMap.getInstance().moveTo(hero, hero.getRevivePosition());
            hero.getHP().set(hero.getLevel().get() * 100);
            hero.getMP().set(hero.getLevel().get() * 100);
        }
    }
}
