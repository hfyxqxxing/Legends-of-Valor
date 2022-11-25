/*
 * Weapon is a subclass of Item, and it is also a MarketItem, InventoryItem
 */

package legendsofvalor.item;

import legendsofvalor.character.Effect_to_Hero;
import legendsofvalor.character.Hero;

public class Weapon extends Item implements Effect_to_Hero {

    private int damage;
    private int hands;

    public Weapon(String name, int level, int price, int sale, int damage, int hands) {
        super(name, level, price, sale);
        this.damage = damage;
        this.hands = hands;
    }

    @Override
    public void effect(Hero hero) {
        /** This should be implemented in hero, adding or subsituting the weapon of hero */
        //        hero.equip_weapon(this);
        System.out.println("Hero equipped a weapon");
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        if (damage < 0) {
            return;
        }
        this.damage = damage;
    }

    public int getHands() {
        return hands;
    }

    public void setHands(int hands) {
        if (hands < 0) {
            return;
        }
        this.hands = hands;
    }

    public String getItemType() {
        return "Weapon";
    }

    public String toString() {
        return "Name: " + getName() + " Level: " + getLevel() + " Damage: " + getDamage() + " Price: " + getPrice() + " Hands: " + getHands();
    }

    public String getMarketHeader() {
        return String.format("%-20s %-10s %-10s %-10s %-10s", "<Weapon>", "Level", "Price", "Damage", "Hands");
    }

    public String getMarketBody() {
        return String.format("%-20s %-10s %-10s %-10s %-10s", getName(), getLevel(), getPrice(), getDamage(), getHands());
    }

    public String getInventoryHeader() {
        return String.format("%-20s %-10s %-10s %-10s", "<Weapon>", "Sale", "Damage", "Hands");
    }

    public String getInventoryBody() {
        return String.format("%-20s %-10s %-10s %-10s", getName(), getSale(), getDamage(), getHands());
    }

    public String getWeaponHeader() {
        return String.format("%-20s %-10s %-10s", "<Weapon>", "Damage", "Hands");
    }

    public String getWeaponBody() {
        return String.format("%-20s %-10s %-10s", getName(), getDamage(), getHands());
    }
}
