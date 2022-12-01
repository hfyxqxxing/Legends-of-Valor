package legendsofvalor.item;

import legendsofvalor.character.Hero;
import legendsofvalor.utils.ColorPrint;

public class PotionRevival extends PotionFunction {
    PotionRevival(int powerUp) {
        super("Revival", powerUp);
    }

    /** The effect here actually should refill all HP and MP */
    @Override
    public void effect(Hero hero) {
        ColorPrint.plain("Hero " + hero.getName() + "'s MP increased by " + powerUp + ".");
        ColorPrint.plain("Hero " + hero.getName() + "'s HP increased by " + powerUp + ".");
        hero.getHP().increase(powerUp);
        hero.getMP().increase(powerUp);
    }
}
