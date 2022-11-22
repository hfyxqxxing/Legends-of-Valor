package world;

import character.Effect_to_Hero;
import character.Hero;

public class Cell_Cave  extends Accessible_Cell implements Effect_to_Hero {

    Cell_Cave(){
        this.symbol = 'C';
        this.name = "Cave";
    }

    @Override
    public void effect(Hero hero){
        hero.getAgility().increase(20);
    }

}
