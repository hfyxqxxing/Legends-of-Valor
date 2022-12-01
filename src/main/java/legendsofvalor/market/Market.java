/*
 * Market to trade items
 */
package legendsofvalor.market;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import legendsofvalor.item.MarketItem;

class SortbyItemType implements Comparator<MarketItem> {
    public int compare(MarketItem a, MarketItem b) {
        return a.getItemType().compareTo(b.getItemType());
    }
}

public class Market {
    private ArrayList<MarketItem> items;

    public Market() {
        items = new ArrayList<MarketItem>();
    }

    public ArrayList<MarketItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<MarketItem> items) {
        this.items = items;
    }

    public void addItem(MarketItem item) {
        items.add(item);
    }

    public void removeItem(MarketItem item) {
        items.remove(item);
    }

    public void sortItems() {
        Collections.sort(items, new SortbyItemType());
    }

    public MarketItem get(int index) {
        return items.get(index);
    }

    public int size() {
        return items.size();
    }

    public String toString() {
        String re = "";

        this.sortItems();

        String lastItemType = "";

        // print out the items in each type
        for (int i = 0; i < items.size(); ++i) {
            if (!items.get(i).getItemType().equals(lastItemType)) {
                re += "\n";
                lastItemType = items.get(i).getItemType();
                String header = items.get(i).getMarketHeader();
                re += "     " + header + "\n" + "     " + String.join("", Collections.nCopies(header.length(), "-")) + "\n";
            }
            re += String.format("%-5s", "[" + (i + 1) + "]") + items.get(i).getMarketBody() + "\n";
        }

        return re;
    }
}
