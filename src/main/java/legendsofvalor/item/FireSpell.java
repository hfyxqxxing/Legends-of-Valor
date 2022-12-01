/*
 * This defines a special kinds of SpellType.
 * When doing attack, the attack method will be called to do the damage.
 */
package legendsofvalor.item;

import legendsofvalor.character.*;

public class FireSpell extends Spell {
    public FireSpell(String name, int level, int price, int sale, int damage, int manaCost, int quantity) {
        super(name, level, price, sale, damage, manaCost, quantity);
        spellType = "Fire";
    }

    @Override
    public void attack(Hero hero, Monster monster) {

    }

}
