package world;

import character.Effect_to_Hero;
import character.Hero;

public class Cell_Koulou  extends Accessible_Cell implements Effect_to_Hero {
        Cell_Koulou(){
                this.symbol = 'K';
                this.name = "Koulou";
        }


        @Override
        public void effect(Hero hero) {
                hero.getStrength().increase(20);
        }
}
