package legendsofvalor.item;

import legendsofvalor.character.Hero;

public class Potion_State extends Potion {
    Potion_State(String name, int level, int price, int sale, int powerUp) {
        super(name, level, price, sale, powerUp);
        function = "State";

    }

    /** The effect here actually should be refill all HP and MP. No MAX_HP/MP now */
    @Override
    public void effect(Hero hero) {
        // hero.getHP().increase(powerUp);
        // hero.getMP().increase(powerUp);
    }
}
