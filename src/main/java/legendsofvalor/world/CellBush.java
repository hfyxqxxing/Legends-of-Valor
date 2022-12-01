package legendsofvalor.world;

import legendsofvalor.character.Hero;

public class CellBush extends AccessibleCell {

    CellBush() {
        this.symbol = 'B';
        this.name = "Bush";
    }

    @Override
    public void effect(Hero hero) {
         hero.getDexterity().increase(20);
    }

}
