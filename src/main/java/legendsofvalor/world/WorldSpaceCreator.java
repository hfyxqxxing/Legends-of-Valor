/*
 * This is the World Space factory class.
 * The create method accept a string indicate the World Space type
 * and creates corresponding WorldSpace object.
 */

package legendsofvalor.world;

public class WorldSpaceCreator {
    public static WorldCell create(String spaceTypeName) {
        switch (spaceTypeName) {
            case "Bush":
                return new CellBush();
            case "Cave":
                return new CellCave();
            case "Nexus":
                return new CellNexus();
            case "Nexus_Monster":
                return new CellNexusMonster();
            case "Plain":
                return new CellPlain();
            case "Wall":
                return new CellWall();
            case "Koulou":
                return new CellKoulou();
            default:
                return null;
        }
    }
}
