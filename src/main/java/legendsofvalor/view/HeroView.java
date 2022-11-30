package legendsofvalor.view;

import legendsofvalor.character.Hero;
import legendsofvalor.utils.ColorPrint;

public class HeroView {
    public static void view(Hero hero) {
        ColorPrint.plain(hero);
    }

}
