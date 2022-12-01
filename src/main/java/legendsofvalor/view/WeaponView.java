package legendsofvalor.view;

import java.util.ArrayList;

import legendsofvalor.character.Hero;
import legendsofvalor.item.Weapon;
import legendsofvalor.utils.ColorPrint;
import legendsofvalor.utils.UserInput;

public class WeaponView {
    public static void view(Hero curHero) {
        while (true) {
            ColorPrint.green("Current Hero's Equippted Weapon:");
            ColorPrint.plain(curHero.getEquippedWeaponList());
            ColorPrint.green("Current Hero's Weapon Inventory:");
            System.out.println(curHero.getInventory().getWeaponString());
            if (curHero.getInventory().getWeaponString().equals("No weapons in inventory")){
                System.out.println();
                return ;
            }
            ColorPrint.query(
                    "Please enter [1] to equip more weapon, enter [2] to unload a weapon, or enter [0] to cancel and go back:");
            int comm = UserInput.getInstance().getChoice(0, 2);
            if (comm == 0) {
                return;
            }
            if (comm == 2) {
                ColorPrint.query("Please enter the index of the weapon you want to unload, or enter [0] to cancel and go back:");
                int index = UserInput.getInstance().getChoice(1, curHero.getEquippedWeaponList().size());
                if (index == 0) {
                    return;
                }
                Weapon item = curHero.getEquippedWeaponList().get(index - 1);
                curHero.getInventory().addItem(item);
                curHero.getEquippedWeaponList().remove(item);
                ColorPrint.green(
                        "You have unloaded " + item.getName() + " successfully. Press Enter to continue...");
                UserInput.getInstance().getNextline();
                continue;
            }
            if (comm == 1) {
                ArrayList<Weapon> weaponList = curHero.getInventory().getAllWeapon();
                ColorPrint.query("Please select a weapon to equip, or enter [0] to cancel and go back:");
                int index = UserInput.getInstance().getChoice(0, weaponList.size());
                if (index == 0) {
                    return;
                }
                Weapon curWeapon = weaponList.get(index - 1);
                if (curWeapon.getHands() > curHero.getHands().get() - curHero.getEquippedWeaponList().getTotalHands()) {
                    ColorPrint.error(
                            "You don't have enough hands to equip this weapon. Press Enter to continue...");
                    UserInput.getInstance().getNextline();
                    continue;
                }
                curHero.getEquippedWeaponList().add(curWeapon);
                curHero.getInventory().removeItem(curWeapon);

                ColorPrint.green(
                        "You have equipped " + curWeapon.getName() + " successfully. Press Enter to continue...");
                UserInput.getInstance().getNextline();

                return;
            }
        }

    }
}
