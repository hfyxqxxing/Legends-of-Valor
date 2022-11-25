package legendsofvalor.world;

import legendsofvalor.character.Effect_to_Hero;
import legendsofvalor.character.Hero;

public class Cell_Bush extends Accessible_Cell implements Effect_to_Hero {

    Cell_Bush() {
        this.symbol = 'B';
        this.name = "Bush";
    }

    @Override
    public void effect(Hero hero) {
        // hero.getDexterity().increase(20);
    }

}
