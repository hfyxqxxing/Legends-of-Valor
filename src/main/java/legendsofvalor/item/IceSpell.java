/*
 * This defines a special kinds of SpellType.
 * When doing attact, the attact method will be called to do the damage.
 */
package legendsofvalor.item;

import legendsofvalor.character.*;

public class IceSpell extends Spell implements EffectToHero, EffectToMonster {
    public IceSpell(String name, int level, int price, int sale, int damage, int manaCost, int quantity) {
        super(name, level, price, sale, damage, manaCost, quantity);
        spellType = "Ice";
    }

    @Override
    public void effect(Hero hero) {
        // hero.getMP().decrease(manaCost);
    }

    @Override
    public void effect(Monster monster) {
        // monster.getDamage().decrease((int) (monster.getDamage().get() * 0.1));
    }

}
