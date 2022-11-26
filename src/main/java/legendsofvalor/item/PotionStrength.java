package legendsofvalor.item;

import legendsofvalor.utils.ColorPrint;
import legendsofvalor.character.Hero;

public class PotionStrength extends PotionFunction {
    PotionStrength(int powerUp) {
        super("Strength", powerUp);

    }

    @Override
    public void effect(Hero hero) {
        ColorPrint.plain("Hero " + hero.getName() + "'s Strength increased by " + powerUp + ".");
        hero.getStrength().increase(powerUp);
    }
}
