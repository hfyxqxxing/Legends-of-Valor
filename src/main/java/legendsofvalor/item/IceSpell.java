/*
 * This defines a special kinds of SpellType.
 * When doing attack, the attack method will be called to do the damage.
 */
package legendsofvalor.item;

import legendsofvalor.character.*;

public class IceSpell extends Spell {
    public IceSpell(String name, int level, int price, int sale, int damage, int manaCost, int quantity) {
        super(name, level, price, sale, damage, manaCost, quantity);
        spellType = "Ice";
    }

    @Override
    public String attack(Hero hero, Monster monster) {
        int damageDecrease = (int) (monster.getDamage().get() * 0.1);
        monster.getDamage().decrease(damageDecrease);
        int damage = getAttackDamage(hero, monster);
        monster.getHP().decrease(damage);
        String re = monster.getName().get() + " damaged by " + damage + ". damage attribute decreased by " + damageDecrease + ". ";

        return re;
    }

}
