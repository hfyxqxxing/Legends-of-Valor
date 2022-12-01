/*
 * This is the Spell class.
 * Each spell has a damage value and the quantity of the spell.
 * The price and sale price of the spell should change according to the usedCount.
 * If the usedCount is equal to the quantity, the price and sale price should be 0.
 */
package legendsofvalor.item;

import legendsofvalor.character.*;
import legendsofvalor.world.CellBush;
import legendsofvalor.world.WorldMap;

public abstract class Spell extends Item {
    protected int damage;
    protected int manaCost;
    protected int quantity;
    protected int usedCount;
    protected String spellType;

    public Spell(String name, int level, int price, int sale, int damage, int manaCost, int quantity) {
        super(name, level, price, sale);
        this.damage = damage;
        this.manaCost = manaCost;
        this.quantity = quantity;
        this.usedCount = 0;
    }


    public abstract String attack(Hero hero, Monster monster);

    /**The method to calculate the exact damage to the monster on exact conditions*/
    protected int getAttackDamage(Hero hero, Monster monster) {
        int dexterity = hero.getDexterity().get();
        if (WorldMap.getInstance().getCell(hero.getPosition()) instanceof CellBush) {
            dexterity *= 1.1;
        }
        int attackDamage = getDamage() + (dexterity / 10000) * getDamage() - monster.getDefense().get();
        return attackDamage;
    }

    /**Getter and Setter--------------------------------------------------------------*/

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        if (damage < 0) {
            return;
        }
        this.damage = damage;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        if (manaCost < 0) {
            return;
        }
        this.manaCost = manaCost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            return;
        }
        this.quantity = quantity;
    }

    public int getUsedCount() {
        return usedCount;
    }

    public void setUsedCount(int usedCount) {
        if (usedCount < 0) {
            return;
        }
        this.usedCount = usedCount;
    }

    public void use() {
        usedCount++;
    }

    public String getSpellType() {
        return spellType;
    }

    public void setSpellType(String spellType) {
        this.spellType = spellType;
    }

    // the price should change according to the usedCount
    @Override
    public int getPrice() {
        return super.getPrice() * (quantity - usedCount) / quantity;
    }

    // the sale price should change according to the usedCount
    @Override
    public int getSale() {
        return super.getSale() * (quantity - usedCount) / quantity;
    }


    /**Print Messages---------------------------------------------------------*/

    public String getItemType() {
        return "Spell";
    }

    public String toString() {
        return "Name: " + getName() + " Level: " + getLevel() + " Price: " + getPrice() + " Damage: " + getDamage() + " Mana Cost: " + getManaCost() + " Quantity: " + getQuantity() + " Used Count: " + getUsedCount() + " Spell Type: " + getSpellType();
    }

    public String getMarketHeader() {
        return String.format("%-20s %-10s %-10s %-10s %-10s %-10s %-10s", "<Spell>", "Level", "Price", "Damage", "ManaCost", "SpellType", "Used/Quantity");
    }

    public String getMarketBody() {
        return String.format("%-20s %-10s %-10s %-10s %-10s %-10s %-10s", getName(), getLevel(), getPrice(), getDamage(), getManaCost(), getSpellType(), getUsedCount() + "/" + getQuantity());
    }

    public String getInventoryHeader() {
        return String.format("%-20s %-10s %-10s %-10s %-10s", "<Spell>", "Sale", "Damage", "ManaCost", "SpellType", "Used/Quantity");
    }

    public String getInventoryBody() {
        return String.format("%-20s %-10s %-10s %-10s %-10s", getName(), getSale(), getDamage(), getManaCost(), getSpellType(), getUsedCount() + "/" + getQuantity());
    }

    public String getSpellHeader() {
        return String.format("%-20s %-10s %-10s %-10s", "<Spell>", "Damage", "ManaCost", "SpellType", "Used/Quantity");
    }

    public String getSpellBody() {
        return String.format("%-20s %-10s %-10s %-10s", getName(), getDamage(), getManaCost(), getSpellType(), getUsedCount() + "/" + getQuantity());
    }
}
