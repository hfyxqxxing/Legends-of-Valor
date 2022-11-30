package legendsofvalor.view;

import java.util.ArrayList;

import legendsofvalor.character.Hero;
import legendsofvalor.item.Potion;
import legendsofvalor.utils.ColorPrint;
import legendsofvalor.utils.GameUtils;
import legendsofvalor.utils.UserInput;

public class PotionView {
    public static boolean view(Hero curHero) {
        while (true) {
            ColorPrint.green("Current Hero's Potion:\n");
            System.out.println(curHero.getInventory().getPotionString());
            ColorPrint.query(
                    "Please enter [1] to consume a potion, enter [2] to show current hero information, or enter [0] to cancel and go back:");
            int comm = UserInput.getInstance().getChoice(0, 2);
            if (comm == 0) {
                return false;
            }
            if (comm == 2) {
                System.out.println(GameUtils.getCharacterTable(curHero));
                continue;
            }
            if (comm == 1) {
                ArrayList<Potion> potionList = curHero.getInventory().getAllPotion();
                ColorPrint.query("Please select a potion to consume, or enter [0] to cancel and go back");
                int index = UserInput.getInstance().getChoice(0, potionList.size());
                if (index == 0) {
                    return false;
                }
                Potion curPotion = potionList.get(index - 1);
                curHero.getInventory().removeItem(curPotion);
                curPotion.effect(curHero);
                ColorPrint.green(
                        "You have consumed " + curPotion.getName() + " successfully. New hero information:");
                System.out.println(GameUtils.getCharacterTable(curHero));

                return true;
            }
        }

    }
}
