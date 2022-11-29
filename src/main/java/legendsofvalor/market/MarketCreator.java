/*
 * create different market in the map
 */
package legendsofvalor.market;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import legendsofvalor.item.*;
import legendsofvalor.utils.ConfigurationAdaptor;

public class MarketCreator {
    // random add items to market
    private static void addItems(Market market, ArrayList<? extends MarketItem> items) {
        int totalItemCount = items.size();
        int itemCount = ThreadLocalRandom.current().nextInt(0, totalItemCount);
        for (int i = 0; i < itemCount; i++) {
            while (true) {
                int index = ThreadLocalRandom.current().nextInt(0, totalItemCount);
                if (!market.getItems().contains(items.get(index))) {
                    market.addItem(items.get(index));
                    break;
                }
            }
        }
    }

    public static Market create() {
        Market market = new Market();
        // add items to market
        ConfigurationAdaptor adaptor = ConfigurationAdaptor.getInstance();
        // weapon
        ArrayList<Weapon> weapons = adaptor.getWeapons();
        addItems(market, weapons);
        // armor
        ArrayList<Armor> armors = adaptor.getArmors();
        addItems(market, armors);
        // potion
        ArrayList<Potion> potions = adaptor.getPotions();
        addItems(market, potions);
        // spell
        ArrayList<Spell> spells = adaptor.getSpells();
        addItems(market, spells);
        return market;
    }

}
