package legendsofvalor.world;

import legendsofvalor.character.Effect_to_Hero;
import legendsofvalor.character.Hero;

public class CellBush extends AccessibleCell implements Effect_to_Hero {

    CellBush() {
        this.symbol = 'B';
        this.name = "Bush";
    }

    @Override
    public void effect(Hero hero) {
        // hero.getDexterity().increase(20);
    }

}
