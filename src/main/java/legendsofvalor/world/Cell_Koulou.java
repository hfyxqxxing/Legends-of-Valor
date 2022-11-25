package legendsofvalor.world;

import legendsofvalor.character.Effect_to_Hero;
import legendsofvalor.character.Hero;

public class Cell_Koulou extends Accessible_Cell implements Effect_to_Hero {
        Cell_Koulou() {
                this.symbol = 'K';
                this.name = "Koulou";
        }


        @Override
        public void effect(Hero hero) {
                // hero.getStrength().increase(20);
        }
}
