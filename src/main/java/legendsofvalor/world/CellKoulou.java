package legendsofvalor.world;

import legendsofvalor.character.Effect_to_Hero;
import legendsofvalor.character.Hero;

public class CellKoulou extends AccessibleCell{
        CellKoulou() {
                this.symbol = 'K';
                this.name = "Koulou";
        }


        @Override
        public void effect(Hero hero) {
                // hero.getStrength().increase(20);
        }
}
