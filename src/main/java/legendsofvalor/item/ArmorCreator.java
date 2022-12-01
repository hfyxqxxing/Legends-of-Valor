/*
 * This is the factory class to creat armor, use by configuration adapter
 */
package legendsofvalor.item;

public class ArmorCreator {

    public static Armor create(String name, int level, int price, int sale, int defense) {
        return new Armor(name, level, price, sale, defense);
    }
}
