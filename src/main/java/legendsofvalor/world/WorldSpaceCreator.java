/*
 * This is the World Space factory class. 
 * The create method accept a string indicate the World Space type
 * and creates corresponding WorldSpace object.
 */

package world;

public class WorldSpaceCreator {
    public static WorldCell create(String spaceTypeName) {
        switch (spaceTypeName) {
            case "Bush":
                return new Cell_Bush();
            case "Cave":
                return new Cell_Cave();
            case "Nexus":
                return new Cell_Nexus();
            case "Nexus_Monster":
                return new Cell_Nexus_Monster();
            case "Plain":
                return new Cell_Plain();
            case "Wall":
                return new Cell_Wall();
            case "Koulou":
                return new Cell_Koulou();
            default:
                return null;
        }
    }
}
