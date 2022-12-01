/*
 * Home cell for heroes. heros can buy items here
 * each nexus should have a unique random generated market
 */

package legendsofvalor.world;


import legendsofvalor.market.Market;
import legendsofvalor.market.MarketCreator;

public class CellNexus extends AccessibleCell {

    private Market market;


    public CellNexus() {
        this.symbol = 'N';
        this.name = "Nexus";
        market = MarketCreator.create();
    }

    public Market getMarket() {
        return market;
    }
}
