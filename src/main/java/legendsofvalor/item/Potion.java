/*
 * Potion is a subclass of Item, and it is also a MarketItem, InventoryItem
 */
package item;

import java.util.ArrayList;

import character.Effect_to_Hero;
import character.Hero;

public abstract class Potion extends Item implements Effect_to_Hero {
    protected int powerUp;
    protected String function;

    public Potion(String name, int level, int price, int sale, int powerUp) {
        super(name, level, price, sale);
        this.powerUp = powerUp;
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

    public void consume(Hero hero) {
        effect(hero);
    }

    @Override
    public void effect(Hero hero) {
        return;
    }

    public String getItemType() {
        return "Potion";
    }

    public String toString() {
        return "Name: " + getName() + " Level: " + getLevel() + " Price: "
                + getPrice() + " Power Up: " + getPowerUp() ;
    }

    public String getMarketHeader() {
        return String.format("%-20s %-10s %-10s %-10s %-10s", "<Potion>", "Level", "Price", "Power Up",
                "Boosts");
    }

    public String getMarketBody() {
        return String.format("%-20s %-10s %-10s %-10s", getName(), getLevel(), getPrice(),
                getPowerUp());
    }

    public String getInventoryHeader() {
        return String.format("%-20s %-10s %-10s", "<Potion>", "Sale", "Power Up");
    }

    public String getInventoryBody() {
        return String.format("%-20s %-10s %-10s", getName(), getSale(), getPowerUp());
    }

    public String getPotionHeader() {
        return String.format("%-20s %-10s", "<Potion>", "Power Up");
    }

    public String getPotionBody() {
        return String.format("%-20s %-10s", getName(), getPowerUp());
    }

}
