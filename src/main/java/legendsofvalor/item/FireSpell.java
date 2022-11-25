/*
 * This defines a special kinds of SpellType.
 * When doing attact, the attact method will be called to do the damage.
 */
package legendsofvalor.item;

import legendsofvalor.character.*;

public class FireSpell extends Spell implements Effect_to_Hero, Effect_to_Monster {
    public FireSpell(String name, int level, int price, int sale, int damage, int manaCost, int quantity) {
        super(name, level, price, sale, damage, manaCost, quantity);
        spellType = "Fire";
    }

    /** If there exists buff for hero, can be written here */
    @Override
    public void effect(Hero hero) {
        // hero.getMP().decrease(manaCost);
    }

    /** In the hero's cast_a_Spell() function works on the damage calculation. */
    @Override
    public void effect(Monster monster) {
        // monster.getDefense().decrease((int) (monster.getDefense().get() * 0.1));
    }


}
