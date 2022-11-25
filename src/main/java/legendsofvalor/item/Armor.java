/*
 * Armor is a subclass of Item, and it is also a MarketItem, InventoryItem
 */
package legendsofvalor.item;

import legendsofvalor.character.Effect_to_Hero;
import legendsofvalor.character.Hero;

public class Armor extends Item implements Effect_to_Hero {
    private int defense;

    public Armor(String name, int level, int price, int sale, int defense) {
        super(name, level, price, sale);
        this.defense = defense;
    }

    @Override
    public void effect(Hero hero) {
        // hero.setArmor(this);
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        if (defense < 0) {
            return;
        }
        this.defense = defense;
    }

    public String getItemType() {
        return "Armor";
    }

    public String toString() {
        return "Name: " + getName() + " Level: " + getLevel() + " Defense: " + getDefense() + " Price: " + getPrice();
    }

    public String getMarketHeader() {
        return String.format("%-20s %-10s %-10s %-10s", "<Armor>", "Level", "Price", "Defense");
    }

    public String getMarketBody() {
        return String.format("%-20s %-10s %-10s %-10s", getName(), getLevel(), getPrice(), getDefense());
    }

    public String getInventoryHeader() {
        return String.format("%-20s %-10s %-10s", "<Armor>", "Sale", "Defense");
    }

    public String getInventoryBody() {
        return String.format("%-20s %-10s %-10s", getName(), getSale(), getDefense());
    }

    public String getArmorHeader() {
        return String.format("%-20s %-10s", "<Armor>", "Defense");
    }

    public String getArmorBody() {
        return String.format("%-20s %-10s", getName(), getDefense());
    }
}
