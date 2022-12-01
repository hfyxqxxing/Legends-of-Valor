/*
 * This defines a special kinds of SpellType.
 * When doing attack, the attack method will be called to do the damage.
 */
package legendsofvalor.item;

import legendsofvalor.character.*;

public class FireSpell extends Spell implements EffectToMonster{
    public FireSpell(String name, int level, int price, int sale, int damage, int manaCost, int quantity) {
        super(name, level, price, sale, damage, manaCost, quantity);
        spellType = "Fire";
    }

    @Override
    public String attack(Hero hero, Monster monster) {
        int defenseDecrease = effect(monster);
        int attackDamage = getAttackDamage(hero, monster);
        monster.getHP().decrease(attackDamage);
        String re = monster.getName().get() + " damaged by " + attackDamage + ". defense decreased by " + defenseDecrease + ". ";
        return re;
    }

    @Override
    public int effect(Monster monster) {
        int defenseDecrease = (int) (monster.getDefense().get() * 0.1);
        monster.getDefense().decrease(defenseDecrease);
        return defenseDecrease;
    }
}
