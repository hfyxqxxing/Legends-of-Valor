/*
 * Wall cell is inaccessible between two lanes
 */
package legendsofvalor.world;

public class CellWall extends InAccessible_Cell {

    CellWall() {
        this.symbol = 'W';
        this.name = "inaccessible";
    }

}
