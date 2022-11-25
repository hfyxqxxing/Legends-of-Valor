package legendsofvalor.item;

import legendsofvalor.character.Hero;

public class Potion_hp extends Potion {
    Potion_hp(String name, int level, int price, int sale, int powerUp) {
        super(name, level, price, sale, powerUp);
        function = "HP";

    }

    @Override
    public void effect(Hero hero) {
        // hero.getHP().increase(powerUp);
    }
}
