/*
 * Base Class for any item in the game
 * including weapons, armor, and potions
 */

package legendsofvalor.item;

public abstract class Item implements InventoryItem, MarketItem {
    private String name;

    private int level;
    private int price;
    private int sale;

    public Item(String name, int level, int price, int sale) {
        this.name = name;
        this.level = level;
        this.price = price;
        this.sale = sale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if (level < 0) {
            return;
        }
        this.level = level;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price < 0) {
            return;
        }
        this.price = price;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        if (sale < 0) {
            return;
        }
        this.sale = sale;
    }

}
