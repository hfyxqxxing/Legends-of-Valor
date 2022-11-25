/*
 * Interface for items that can be listed on the market
 */
package legendsofvalor.item;

public interface MarketItem {
    public abstract int getPrice();

    public abstract int getSale();

    public abstract String getName();

    public abstract String getItemType();

    public abstract int getLevel();

    public abstract String getMarketHeader();

    public abstract String getMarketBody();
}
