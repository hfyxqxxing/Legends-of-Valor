package legendsofvalor.world;

import legendsofvalor.character.Hero;
import legendsofvalor.market.Market;
import legendsofvalor.market.MarketCreator;

public class Cell_Nexus extends AccessibleCell {

    private Market market;

    public Cell_Nexus() {
        this.symbol = 'N';
        this.name = "Nexus";
        market = MarketCreator.create();
    }

    public Market getMarket() {
        return market;
    }
}
