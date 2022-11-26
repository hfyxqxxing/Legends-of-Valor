package legendsofvalor.item;

import legendsofvalor.character.Hero;
import legendsofvalor.utils.ColorPrint;

public class PotionAgility extends PotionFunction {

    PotionAgility(int powerUp) {
        super("Agility", powerUp);

    }

    @Override
    public void effect(Hero hero) {
        ColorPrint.plain("Hero " + hero.getName() + "'s Agility increased by " + powerUp + ".");
        hero.getAgility().increase(powerUp);
    }
}
