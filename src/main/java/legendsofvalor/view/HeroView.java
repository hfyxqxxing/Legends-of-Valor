/*
 * For each hero's turn, the hero will be redirct to this view
 * heroes are provided a sort of options, including: moving around, attack, use item, etc.
 * when hern choosed a specific action, he will be redirected to corresponding view
 */

package legendsofvalor.view;

import legendsofvalor.character.Hero;
import legendsofvalor.market.Market;
import legendsofvalor.utils.ColorPrint;
import legendsofvalor.utils.GameUtils;
import legendsofvalor.utils.UserInput;
import legendsofvalor.world.CellNexus;
import legendsofvalor.world.Position;
import legendsofvalor.world.WorldMap;

public class HeroView {

    private static String getHelp() {
        String re = "Game Legends of Valor\n";
        re += "In this game, you can move around using [w]/[s]/[a]/[d] in the map. You need to reach the monsters' Nexus to win\n";
        re += "You can buy items in your Nexus\n";
        re += "If the monster entered your Nexus, you failed and game is over\n";

        return re;
    }

    private static boolean tryMove(Hero hero, String direction) {
        Position newPos = WorldMap.getInstance().canMoveTo(hero, direction);
        if (newPos == null) {
            ColorPrint.error("You can't move to that direction. Press Enter to continue...");
            UserInput.getInstance().getNextline();
            return false;
        }
        WorldMap.getInstance().moveTo(hero, newPos);
        return true;
    }

    public static void view(Hero hero) {
        while (true) {
            String comm;
            if (WorldMap.getInstance().isInNexusHero(hero.getPosition())) {
                ColorPrint.plain("Enter [w]/[s]/[a]/[d] to move arouund, [h] for help, [i] for inventory, [m] for map, [q] for quit \n[1] attack, [2] spell, [3] potion, [4] weapon, [5] armor, [6] skip turn, [7] return to nexus, [8] teleport, [9] market, [0] show info. (edit weapon/armor, go to the market, show info do not count as a turn) ");
            } else {
                ColorPrint.plain("Enter [w]/[s]/[a]/[d] to move arouund, [h] for help, [i] for inventory, [m] for map, [q] for quit \n[1] attack, [2] spell, [3] potion, [4] weapon, [5] armor, [6] skip turn, [7] return to nexus, [8] teleport, [0] show info. (edit weapon/armor, show info do not count as a turn) ");
            }
            comm = UserInput.getInstance().getString().trim().toLowerCase();
            if (comm.equals("w")) {
                if (tryMove(hero, "Up")) {
                    return;
                } else {
                    continue;
                }
            }
            if (comm.equals("s")) {
                if (tryMove(hero, "Down")) {
                    return;
                } else {
                    continue;
                }
            }
            if (comm.equals("a")) {
                if (tryMove(hero, "Left")) {
                    return;
                } else {
                    continue;
                }
            }
            if (comm.equals("d")) {
                if (tryMove(hero, "Right")) {
                    return;
                } else {
                    continue;
                }
            }
            if (comm.equals("h")) {
                ColorPrint.plain(getHelp());
                continue;
            }
            if (comm.equals("i")) {
                ColorPrint.plain(hero.getInventory());
                continue;
            }
            if (comm.equals("m")) {
                ColorPrint.plain(WorldMap.getInstance());
                continue;
            }
            if (comm.equals("q")) {
                ColorPrint.green("Game Over");
                System.exit(0);
            }
            if (comm.equals("1")) {
                if (AttackView.view(hero)) {
                    return;
                } else {
                    continue;
                }
            }
            if (comm.equals("2")) {
                if (SpellView.view(hero)) {
                    return;
                } else {
                    continue;
                }
            }
            if (comm.equals("3")) {
                PotionView.view(hero);
                continue;
            }
            if (comm.equals("4")) {
                WeaponView.view(hero);
                continue;
            }
            if (comm.equals("5")) {
                ArmorView.view(hero);
                continue;
            }
            if (comm.equals("6")) {
                ColorPrint.plain("You have skipped this turn.");
                return;
            }
            if (comm.equals("7")) {
                Position nexusPos = hero.getRevivePosition();
                WorldMap.getInstance().moveTo(hero, nexusPos);
                return;
            }
            if (comm.equals("8")) {
                if (TeleportView.view(hero)) {
                    return;
                } else {
                    continue;
                }
            }
            if (comm.equals("9")) {
                if (!WorldMap.getInstance().isInNexusHero(hero.getPosition())) {
                    ColorPrint.error("You are not in the nexus, so you cannot go to the market. Press Enter to continue...");
                    UserInput.getInstance().getNextline();
                    continue;
                }
                Market market = ((CellNexus) WorldMap.getInstance().getCell(hero.getPosition())).getMarket();
                MarketView.view(hero, market);
                continue;
            }
            if (comm.equals("0")) {
                ColorPrint.plain(GameUtils.getCharacterTable(WorldMap.getInstance().getHeroes()));
                ColorPrint.plain(GameUtils.getCharacterTable(WorldMap.getInstance().getMonsters()));
                continue;
            }
        }


    }

}
