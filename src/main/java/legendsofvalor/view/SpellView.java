package legendsofvalor.view;

import java.util.ArrayList;

import legendsofvalor.character.Hero;
import legendsofvalor.character.Monster;
import legendsofvalor.item.Spell;
import legendsofvalor.utils.ColorPrint;
import legendsofvalor.utils.GameUtils;
import legendsofvalor.utils.UserInput;
import legendsofvalor.world.WorldMap;

public class SpellView {
    public static boolean view(Hero hero) {
        ArrayList<Monster> monsters = WorldMap.getInstance().getAttackScope(hero);
        if (monsters.size() == 0) {
            ColorPrint.error("No monster in attack scope");
            return false;
        }
        ColorPrint.green("Current Hero's Spell:\n");
        ColorPrint.plain(hero.getInventory().getSpellString());
        ArrayList<Spell> spellList = hero.getInventory().getAllSpell();
        ColorPrint.query("Please select a spell to attack, or enter [0] to cancel and go back:");
        int index = UserInput.getInstance().getChoice(0, spellList.size());
        if (index == 0) {
            return false;
        }
        Spell curSpell = spellList.get(index - 1);
        if (curSpell.getManaCost() > hero.getMP().get()) {
            ColorPrint.error("You don't have enough mana to perform this spell attack");
            return false;
        }
        ColorPrint.info("Please choose a monster to attac, or enter [0] to cancel and go back:");
        ColorPrint.plain(GameUtils.getCharacterTable(monsters));
        index = UserInput.getInstance().getChoice(1, monsters.size());
        if (index == 0) {
            return false;
        }
        Monster curMonster = monsters.get(index - 1);
        curSpell.attack(hero, curMonster);

        return true;

    }

}
