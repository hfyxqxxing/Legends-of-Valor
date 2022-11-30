package legendsofvalor.world;

import legendsofvalor.character.EffectToHero;
import legendsofvalor.character.Hero;

public class CellCave extends AccessibleCell {

    CellCave() {
        this.symbol = 'C';
        this.name = "Cave";
    }

    @Override
    public void effect(Hero hero) {
        // hero.getAgility().increase(20);
    }

}
