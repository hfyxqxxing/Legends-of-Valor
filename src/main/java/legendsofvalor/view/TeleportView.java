/*
 * This is the view of teleport. Hero can teleport to other hero here.
 * return false if teleport is canceled.
 */

package legendsofvalor.view;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import legendsofvalor.character.Hero;
import legendsofvalor.utils.ColorPrint;
import legendsofvalor.utils.GameUtils;
import legendsofvalor.utils.UserInput;
import legendsofvalor.world.Position;
import legendsofvalor.world.WorldMap;

public class TeleportView {
    public static boolean view(Hero hero) {
        ArrayList<Hero> teleportList = new ArrayList<Hero>(WorldMap.getInstance().getHeroes());
        teleportList.remove(hero);
        ColorPrint.info("List of other heroes in the world:");
        ColorPrint.plain(GameUtils.getCharacterTable(teleportList));
        while (true) {
            ColorPrint.query("Please select a hero to teleport to, or enter [0] to cancel and go back:");
            int index = UserInput.getInstance().getChoice(0, teleportList.size());
            if (index == 0) {
                return false;
            }
            Hero targetHero = teleportList.get(index - 1);
            ArrayList<Position> possiblePosition = WorldMap.getInstance().canTeleport(hero, targetHero);
            if (possiblePosition.size() == 0) {
                ColorPrint.error("No possible teleport position near this hero");
                return false;
            }
            // random choose a teleport position
            int random = ThreadLocalRandom.current().nextInt(0, possiblePosition.size());
            Position teleportPosition = possiblePosition.get(random);
            WorldMap.getInstance().moveTo(hero, teleportPosition);
            ColorPrint.green("You have teleported to " + targetHero.getName().get() + " nearby successfully.");
            return true;
        }

    }
}
