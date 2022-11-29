package legendsofvalor.world;

import javafx.geometry.Pos;
import legendsofvalor.character.Hero;

import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;


public class WorldMap {
    private int rows;
    private int cols;
    private WorldCell[][] map;

    public WorldMap(int row, int col) {
        this.rows = row;
        this.cols = col;
        this.map = new WorldCell[row][col];
    }


    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    // get whole map
    public WorldCell[][] getMap() {
        return map;
    }

    public void setMap(WorldCell[][] map) {
        this.map = map;
    }

    public WorldCell getMap(int x, int y) {
        if (x >= this.rows || y >= this.cols || x < 0 || y < 0)
            return null;
        return this.map[x][y];
    }

    public void setMap(Position position, WorldCell value) {
        int x = position.getX();
        int y = position.getY();
        if (x >= this.rows || y >= this.cols || x < 0 || y < 0)
            return;
        this.map[x][y] = value;
    }

    /** The method to get the lane*/
    public int getLane(Position pos){
        int y = pos.getY();
        int count = 1;
        if (y % 3 == 2){
            System.out.println("This is an inaccessible position, not a Lane");
            return -1;
        }
        while (true){
            if (y < count*3-1 ){
                return count-1;
            }
            count++;
        }
    }


    public boolean isInANexus(Position position) {
        return map[position.getX()][position.getY()].getSymbol() == ('N');
    }

    /** Need changes */
    public String toString(Position position) {
        String re = "";
        re += "+" + String.join("", Collections.nCopies(this.rows, "---+")) + "\n";
        for (int i = 0; i < this.cols; i++) {
            re += "|";
            for (int j = 0; j < this.rows; j++) {
                if (i == position.getX() && j == position.getY()) {
                    re += "*H*|";
                } else {
                    re += " " + this.map[i][j].getSymbol() + " |";
                }

            }
            re += "\n";
            re += "+" + String.join("", Collections.nCopies(this.rows, "---+")) + "\n";
        }
        if (isInANexus(position)) {
            re += "You are in a market. You can buy or sell items here.\n";
        } else {
            re += "You are not in a market. You can move around the map.\n";
        }
        return re;
    }

    public static void main(String[] args) {
        WorldMapCreator wm = new WorldMapCreator(8, 8, 0.1, 0.1, 0.1, 2);
        WorldMap world = wm.create();
        System.out.println(world.toString(new Position(7,0)));
    }
    // Sample Output:

    // +---+---+---+---+---+---+---+---+
    // | M | M | W | M | M | W | M | M |
    // +---+---+---+---+---+---+---+---+
    // | P | P | W | P | P | W | P | P |
    // +---+---+---+---+---+---+---+---+
    // | P | B | W | K | P | W | B | P |
    // +---+---+---+---+---+---+---+---+
    // | P | B | W | P | P | W | P | P |
    // +---+---+---+---+---+---+---+---+
    // | P | B | W | P | P | W | P | C |
    // +---+---+---+---+---+---+---+---+
    // | P | P | W | P | P | W | P | P |
    // +---+---+---+---+---+---+---+---+
    // | P | P | W | C | C | W | B | P |
    // +---+---+---+---+---+---+---+---+
    // |*H*| N | W | N | N | W | N | N |
    // +---+---+---+---+---+---+---+---+
    // You are in a market. You can buy or sell items here.
}
