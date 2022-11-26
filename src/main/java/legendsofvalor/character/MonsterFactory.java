/*
 * This is the factory class for creating monsters.
 * We retrive the templates from the configuration adaptor.
 * random select one monster, make a copy, scale up its attributes and return it.
 */

package legendsofvalor.character;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import legendsofvalor.utils.ConfigurationAdaptor;

public class MonsterFactory {
    public static Monster create(int level) {
        Monster m;
        ConfigurationAdaptor config = ConfigurationAdaptor.getInstance();

        ArrayList<Monster> monsterList = config.getMonsters();

        // random select a monster
        int choice = ThreadLocalRandom.current().nextInt(0, monsterList.size());

        Monster currentMonster = monsterList.get(choice);

        m = new Monster(currentMonster.getName(), currentMonster.getHP(), currentMonster.getLevel(), currentMonster.getDamage(), currentMonster.getDefense(), currentMonster.getAgility(), currentMonster.getMonsterType());
        // important
        // scale up the monster's attributes
        m.setLevel(new Level(level));
        double scaleFactor = 1.0 * level / currentMonster.getLevel().get();
        m.setHP(new HP((int) (m.getHP().get() * scaleFactor)));
        m.setDamage(new Damage((int) (m.getDamage().get() * scaleFactor)));
        m.setDefense(new Defense((int) (m.getDefense().get() * scaleFactor)));
        m.setAgility(new Agility((int) (m.getAgility().get() * scaleFactor)));
        return m;
    }
}
