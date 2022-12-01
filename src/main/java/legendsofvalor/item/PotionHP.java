/*
 * Potion function to increase HP
 * One potion may contains multiple potion funciton
 */
package legendsofvalor.item;

import legendsofvalor.character.Hero;
import legendsofvalor.utils.ColorPrint;

public class PotionHP extends PotionFunction {
    PotionHP(int powerUp) {
        super("HP", powerUp);
    }

    @Override
    public void effect(Hero hero) {
        ColorPrint.plain("Hero " + hero.getName() + "'s HP increased by " + powerUp + ".");
        hero.getHP().increase(powerUp);
    }
}
