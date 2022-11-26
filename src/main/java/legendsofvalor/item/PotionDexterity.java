package legendsofvalor.item;

import legendsofvalor.character.Hero;
import legendsofvalor.utils.ColorPrint;

public class PotionDexterity extends PotionFunction {
    PotionDexterity(int powerUp) {
        super("Dexterity", powerUp);
    }

    @Override
    public void effect(Hero hero) {
        ColorPrint.plain("Hero " + hero.getName() + "'s Dexterity increased by " + powerUp + ".");
        hero.getDexterity().increase(powerUp);
    }
}
