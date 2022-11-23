/*
 * This is an interface that defines a special kinds of item, the Inventory will use this interface to store the item.
 */
package item;

public interface InventoryItem {

    public abstract String getName();

    public abstract String getItemType();

    public abstract String getInventoryHeader();

    public abstract String getInventoryBody();
}
