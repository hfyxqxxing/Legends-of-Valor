package legendsofvalor.view;

import legendsofvalor.character.Hero;
import legendsofvalor.item.InventoryItem;
import legendsofvalor.item.MarketItem;
import legendsofvalor.market.Market;
import legendsofvalor.utils.ColorPrint;
import legendsofvalor.utils.UserInput;

public class MarketView {

    public static void view(Hero curHero, Market market) {
        ColorPrint.green("Welcome to the market!");
        while (true) {
            ColorPrint.info("You have " + curHero.getGold().get() + " gold.");
            ColorPrint.info("Items to buy:");
            ColorPrint.plain(market);
            ColorPrint.info("Items to sell:");
            ColorPrint.plain(curHero.getInventory());
            ColorPrint.query(
                    "Enter [1] for purchase, enter [2] for selling inventary, enter [3] for back to main menu:");
            int comm = UserInput.getInstance().getChoice(1, 3);
            if (comm == 1) {
                ColorPrint.query("Please enter the index of the item you want to buy:");
                int index = UserInput.getInstance().getChoice(1, market.size());
                MarketItem item = market.get(index);
                int price = item.getPrice();
                if (curHero.getLevel().get() < item.getLevel()) {
                    ColorPrint.error("You don't have enough level to buy this item. Press Enter to continue...");
                    UserInput.getInstance().getNextline();
                    continue;
                }
                if (!curHero.getGold().isGoldEnough(price)) {
                    ColorPrint.error("You don't have enough gold to buy this item. Press Enter to continue...");
                    UserInput.getInstance().getNextline();
                    continue;
                }

                curHero.getGold().decrease(price);
                curHero.getInventory().addItem((InventoryItem) market.get(index));
                market.removeItem(item);
                ColorPrint.green(
                        "You have bought " + item.getName() + " successfully. Press Enter to continue...");
                UserInput.getInstance().getNextline();

            } else if (comm == 2) {
                ColorPrint.query("Please enter the index of the item you want to sell:");
                int index = UserInput.getInstance().getChoice(1, market.size());

                MarketItem item = (MarketItem) curHero.getInventory().get(index);
                curHero.getGold().increase(item.getSale());
                curHero.getInventory().removeItem(curHero.getInventory().get(index));
                market.addItem(item);
                ColorPrint.green("You have sold " + item.getName() + " successfully. Press Enter to continue...");
                UserInput.getInstance().getNextline();

            } else if (comm == 3) {
                break;
            } else {
                ColorPrint.error("Please enter a valid command.");
            }

        }

    }
}

