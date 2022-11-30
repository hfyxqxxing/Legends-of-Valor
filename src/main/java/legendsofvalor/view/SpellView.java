package legendsofvalor.view;

import java.util.ArrayList;

import legendsofvalor.character.Hero;
import legendsofvalor.character.Monster;
import legendsofvalor.item.Spell;
import legendsofvalor.utils.ColorPrint;
import legendsofvalor.utils.UserInput;

public class SpellView {
    public static Spell view(Hero curHero, Monster monster) {
        ColorPrint.green("Current Hero's Spell:\n");
        System.out.println(curHero.getInventory().getSpellString());
        while (true) {
            ColorPrint.query(
                    "Please enter [1] to perform spell attack, or enter [0] to cancel and go back:");
            int comm = UserInput.getInstance().getChoice(0, 1);
            if (comm == 0) {
                ColorPrint.info("Cancel spell attack");
                return null;
            }
            if (comm == 1) {
                ArrayList<Spell> spellList = curHero.getInventory().getAllSpell();
                ColorPrint.query("Please select a spell to attack, or enter [0] to cancel and go back:");
                int index = UserInput.getInstance().getChoice(0, spellList.size());
                if (index == 0) {
                    return null;
                }
                Spell curSpell = spellList.get(index - 1);
                if (curSpell.getManaCost() > curHero.getMP().get()) {
                    ColorPrint.error("You don't have enough mana to perform this spell attack");
                    continue;
                }
                // use the current spell
                curSpell.attack(curHero, monster);
            }
        }
    }
}
