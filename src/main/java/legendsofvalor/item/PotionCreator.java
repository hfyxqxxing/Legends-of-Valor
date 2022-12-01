/*
 * This is the factory class for creating SpellType.
 * The create method accept a string indicate the spell type,
 * return the corresponding SpellType object.
 */

package legendsofvalor.item;

public class PotionCreator {

    public static Potion create(String name, int level, int price, int sale, int powerUp, String funcitons) {
        Potion p = new Potion(name, level, price, sale, powerUp);
        String[] funcitonList = funcitons.split("/");
        for (String function : funcitonList) {
            if (function.equals("Dexterity")) {
                p.addFunction(new PotionDexterity(powerUp));
            } else if (function.equals("Defense")) {
                p.addFunction(new PotionDefense(powerUp));
            } else if (function.equals("Strength")) {
                p.addFunction(new PotionStrength(powerUp));
            } else if (function.equals("Revival")) {
                p.addFunction(new PotionRevival(powerUp));
            } else if (function.equals("HP")) {
                p.addFunction(new PotionHP(powerUp));
            } else if (function.equals("MP")) {
                p.addFunction(new PotionMP(powerUp));
            } else if (function.equals("Agility")) {
                p.addFunction(new PotionAgility(powerUp));
            }
        }
        return p;
    }
}
