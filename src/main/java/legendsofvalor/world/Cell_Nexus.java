package world;

import character.Hero;
import inventory.Market;
public class Cell_Nexus extends Accessible_Cell {

    private Market market;

    public Cell_Nexus(){
        this.symbol = 'N';
        this.name = "Nexus";
        market = new Market();
    }


    public void shopping(Hero hero){
        market.shopping(hero);
    }

}
