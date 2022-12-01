/*
 * The world map creator. The cells in the worldmap are created by a specific probability.
 */
package legendsofvalor.world;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class WorldMapCreator {

    public static WorldMap create() {
        return WorldMapCreator.create(8, 8, 0.2, 0.3, 0.5, new Random());
    }

    public static WorldMap create(int seed) {
        return WorldMapCreator.create(8, 8, 0.2, 0.3, 0.5, new Random(seed));
    }

    public static WorldMap create(int row, int col, int seed) {
        return create(row, col, 0.2, 0.3, 0.5, new Random(seed));
    }

    public static WorldMap create(int row, int col, double bushProbability, double caveProbability, double koulouProbability, int seed) {
        return create(row, col, bushProbability, caveProbability, koulouProbability, new Random(seed));
    }

    public static WorldMap create(int row, int col, double bushProbability, double caveProbability, double koulouProbability, Random random) {
        WorldMap wm = new WorldMap(row, col);
        ArrayList<Position> plains = new ArrayList<>();
        int b_count = 0;
        int c_count = 0;
        int k_count = 0;

        /** Should be rows and cols. */
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                Position position = new Position(i, j);
                if ((j % 3) == 2) {
                    wm.setMap(position, WorldSpaceCreator.create("Wall"));
                    continue;
                }
                if (i == 0) {
                    wm.setMap(position, WorldSpaceCreator.create("Nexus_Monster"));
                    continue;
                }
                if (i == 7) {
                    wm.setMap(position, WorldSpaceCreator.create("Nexus"));
                    continue;
                }

                double r = random.nextDouble();
                if (r < bushProbability) {
                    wm.setMap(position, WorldSpaceCreator.create("Bush"));
                    b_count++;
                } else if (r < caveProbability) {
                    wm.setMap(position, WorldSpaceCreator.create("Cave"));
                    c_count++;
                } else if (r < koulouProbability) {
                    wm.setMap(position, WorldSpaceCreator.create("Koulou"));
                    k_count++;
                } else {
                    wm.setMap(position, WorldSpaceCreator.create("Plain"));
                    plains.add(new Position(i, j));
                }
            }
        }
        if (plains.isEmpty()) {
            System.out.println("All special places. Not available map");
            return wm;
        }
        Collections.shuffle(plains);

        if (b_count == 0) {
            Position position = plains.remove(0);
            wm.setMap(position, WorldSpaceCreator.create("Bush"));
        }
        if (c_count == 0) {
            Position position = plains.remove(0);
            wm.setMap(position, WorldSpaceCreator.create("Cave"));
        }
        if (k_count == 0) {
            Position position = plains.remove(0);
            wm.setMap(position, WorldSpaceCreator.create("Koulou"));
        }
        return wm;
    }
}
