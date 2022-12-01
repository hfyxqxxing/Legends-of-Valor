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
        // first try move down
        Position position = WorldMap.getInstance().canMoveDown(monster);
        // can move down
        if (position != null) {
            WorldMap.getInstance().moveTo(monster, position);
            return;
        }
        // can't move down, try attack
        ArrayList<Hero> heroes = WorldMap.getInstance().getAttackScope(monster);
        if (heroes.size() == 0) {
            return;
        }
        // do attact to first hero
        Hero hero = heroes.get(0);
        String result = monster.attack(hero);
        System.out.println(result);
        // if hero is dead, send back to nuxes, wait for revive
        if (hero.getHP().get() <= 0) {
            WorldMap.getInstance().moveTo(hero, hero.getRevivePosition());
        }
    }
}
