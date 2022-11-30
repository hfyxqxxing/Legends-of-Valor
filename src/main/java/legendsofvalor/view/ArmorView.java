package legendsofvalor.view;

import java.util.ArrayList;

import legendsofvalor.character.Hero;
import legendsofvalor.item.Armor;
import legendsofvalor.utils.ColorPrint;
import legendsofvalor.utils.UserInput;

public class ArmorView {
    public static void view(Hero curHero) {
        while (true) {
            ColorPrint.green("Current Hero's Armor:\n");
            ColorPrint.plain(curHero.getInventory().getArmorString());
            ColorPrint.query(
                    "Please enter [1] to add/replace the armor(limit 1), enter [2] to remove current hero's armor, or enter [0] to cancel and go back:");
            int comm = UserInput.getInstance().getChoice(0, 2);
            if (comm == 0) {
                return;
            }
            if (comm == 2) {
                Armor curArmor = curHero.getArmor();
                curHero.setArmor(null);
                curHero.getInventory().addItem(curArmor);
                ColorPrint.green("You have removed " + curArmor.getName() + " successfully.");
                continue;
            }
            if (comm == 1) {
                ArrayList<Armor> armorList = curHero.getInventory().getAllArmor();
                ColorPrint.query("Please enter the index of the armor you want to equip, or enter [0] to cancel and go back");
                int index = UserInput.getInstance().getChoice(0, armorList.size());
                if (index == 0) {
                    return;
                }
                Armor curArmor = armorList.get(index - 1);
                curHero.getInventory().removeItem(curArmor);
                curHero.setArmor(curArmor);

                ColorPrint.green("You have equipped " + curArmor.getName() + " successfully.");
                continue;
            }
        }

    }
}
