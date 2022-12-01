/*
 * This is the factory class for creating SpellType.
 * Use by configuration adapter
 */
package legendsofvalor.item;

public class WeaponCreator {

    public static Weapon create(String name, int level, int price, int sale, int damage, int hands) {
        return new Weapon(name, level, price, sale, damage, hands);
    }
}
