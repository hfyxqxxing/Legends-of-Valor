/*
 * Potion function to increase MP
 * One potion may contains multiple potion funciton
 */
package legendsofvalor.item;

import legendsofvalor.character.Hero;
import legendsofvalor.utils.ColorPrint;

public class PotionMP extends PotionFunction {
    PotionMP(int powerUp) {
        super("MP", powerUp);
    }

    @Override
    public void effect(Hero hero) {
        ColorPrint.plain("Hero " + hero.getName() + "'s MP increased by " + powerUp + ".");
        hero.getMP().increase(powerUp);
    }
}
