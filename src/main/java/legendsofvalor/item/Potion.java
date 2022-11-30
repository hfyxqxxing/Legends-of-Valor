/*
 * Potion is a subclass of Item, and it is also a MarketItem, InventoryItem
 * Using a strategy pattern to implement the multi-use potions.
 */

package legendsofvalor.item;

import java.util.ArrayList;

import legendsofvalor.character.*;

public class Potion extends Item implements EffectToHero {
    protected int powerUp;
    protected ArrayList<PotionFunction> potionFunctions;

    public Potion(String name, int level, int price, int sale, int powerUp) {
        super(name, level, price, sale);
        this.powerUp = powerUp;
        this.potionFunctions = new ArrayList<PotionFunction>();
    }

    public int getPowerUp() {
        return powerUp;
    }

    public void setPowerUp(int powerUp) {
        if (powerUp < 0) {
            return;
        }
        this.powerUp = powerUp;
    }

    @Override
    public void effect(Hero hero) {
        for (PotionFunction potionFunction : potionFunctions) {
            potionFunction.effect(hero);
        }
    }

    public String getItemType() {
        return "Potion";
    }

    public void addFunction(PotionFunction potionFunction) {
        potionFunctions.add(potionFunction);
    }

    public ArrayList<PotionFunction> getPotionFunctions() {
        return potionFunctions;
    }

    public String getFunctionsString() {
        String re = "";
        for (PotionFunction potionFunction : potionFunctions) {
            re += potionFunction.getFunction() + "/";
        }
        if (re.equals("") ) {
            return "";
        }
        return re.substring(0, re.length() - 1);
    }

    public String toString() {
        return "Name: " + getName() + " Level: " + getLevel() + " Price: " + getPrice() + " Power Up: " + getPowerUp();
    }

    public String getMarketHeader() {
        return String.format("%-20s %-10s %-10s %-10s %-10s", "<Potion>", "Level", "Price", "Power Up", "Boosts");
    }

    public String getMarketBody() {
        return String.format("%-20s %-10s %-10s %-10s %-10s", getName(), getLevel(), getPrice(), getPowerUp(), getFunctionsString());
    }

    public String getInventoryHeader() {
        return String.format("%-20s %-10s %-10s %-10s", "<Potion>", "Sale", "Power Up", "Boosts");
    }

    public String getInventoryBody() {
        return String.format("%-20s %-10s %-10s %-10s", getName(), getSale(), getPowerUp(), getFunctionsString());
    }

    public String getPotionHeader() {
        return String.format("%-20s %-10s %-10s", "<Potion>", "Power Up", "Boosts");
    }

    public String getPotionBody() {
        return String.format("%-20s %-10s %-10s", getName(), getPowerUp(), getFunctionsString());
    }

}
