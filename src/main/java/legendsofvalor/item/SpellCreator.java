/*
 * This is the factory class for creating SpellType.
 * The create method accept a string indicate the spell type, 
 * return the corresponding SpellType object.
 */

package item;

public class SpellCreator {

    public static Spell create(String type, String name, int level, int price, int sale, int damage, int manaCost,
                               int quantity){
        if (type.equalsIgnoreCase("fire")){
            return new FireSpell(name,level,price,sale,damage,manaCost,quantity);
        } else if (type.equalsIgnoreCase("Ice")) {
            return new IceSpell(name,level,price,sale,damage,manaCost,quantity);
        } else if (type.equalsIgnoreCase("Lightning")) {
            return new LightningSpell(name,level,price,sale,damage,manaCost,quantity);
        }else {
            System.out.println("Not an available type");
            return null;
        }
    }
}
