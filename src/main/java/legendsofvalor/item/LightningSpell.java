/*
 * This defines a special kinds of SpellType.
 * When doing attack, the attack method will be called to do the damage.
 */
package legendsofvalor.item;

import legendsofvalor.character.*;

public class LightningSpell extends Spell implements EffectToMonster {
    public LightningSpell(String name, int level, int price, int sale, int damage, int manaCost, int quantity) {
        super(name, level, price, sale, damage, manaCost, quantity);
        spellType = "Lightning";
    }

    @Override
    public String attack(Hero hero, Monster monster) {
        int AgilityDecrease = effect(monster);
        int damage = getAttackDamage(hero, monster);
        monster.getHP().decrease(damage);
        String re = monster.getName().get() + " damaged by " + damage + ". agility decreased by " + AgilityDecrease + ". ";
        return re;
    }

    @Override
    public int effect(Monster monster) {
        int AgilityDecrease = (int) (monster.getAgility().get() * 0.1);
        monster.getAgility().decrease(AgilityDecrease);
        return AgilityDecrease;
    }
}
