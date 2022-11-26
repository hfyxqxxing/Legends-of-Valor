package legendsofvalor.item;

import legendsofvalor.character.Hero;
import legendsofvalor.utils.ColorPrint;

public class PotionDefense extends PotionFunction {
    PotionDefense(int powerUp) {
        super("Defense", powerUp);
    }

    @Override
    public void effect(Hero hero) {
        ColorPrint.plain("Hero " + hero.getName() + "'s Defense increased by " + powerUp + ".");
        hero.getDefense().increase(powerUp);
    }
}
