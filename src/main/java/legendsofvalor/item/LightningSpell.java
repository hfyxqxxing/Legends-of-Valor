/*
 * This defines a special kinds of SpellType.
 * When doing attact, the attact method will be called to do the damage.
 */
package legendsofvalor.item;

import legendsofvalor.character.*;

public class LightningSpell extends Spell {
    public LightningSpell(String name, int level, int price, int sale, int damage, int manaCost, int quantity) {
        super(name, level, price, sale, damage, manaCost, quantity);
        spellType = "Lightning";
    }

    @Override
    public void effect(Hero hero) {
        // hero.getMP().decrease(manaCost);
    }

    @Override
    public void effect(Monster monster) {
        // monster.getAgility().decrease((int) (monster.getAgility().get() * 0.1));
    }
}
