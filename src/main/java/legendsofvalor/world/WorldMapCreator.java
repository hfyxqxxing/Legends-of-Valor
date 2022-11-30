package legendsofvalor.world;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class WorldMapCreator {
    private double bushProbability;
    private double caveProbability;
    private double koulouProbability;

    private int cols;
    private int rows;

    private Random random;



    public WorldMapCreator() {
        this.cols = 8;
        this.rows = 8;
        this.bushProbability = 0.2;
        this.caveProbability = 0.2;
        this.koulouProbability = 0.2;
        this.random = new Random();
    }

    public WorldMapCreator(int row, int col, int seed) {
        this.cols = col;
        this.rows = row;
        this.bushProbability = 0.2;
        this.caveProbability = 0.3;
        this.koulouProbability = 0.5;
        this.random = new Random(seed);
    }

    public WorldMapCreator(int row, int col, double bushProbability, double caveProbability, double koulouProbability, int seed) {
        this.cols = col;
        this.rows = row;
        /** Probabilities should have a max value */
        this.bushProbability = bushProbability;
        this.caveProbability = caveProbability + this.bushProbability;
        this.koulouProbability = koulouProbability + this.caveProbability;
        this.random = new Random(seed);
    }

    public WorldMap create() {
        WorldMap wm = new WorldMap(rows,cols);
        ArrayList<Position> plains = new ArrayList<>();
        int b_count = 0;
        int c_count = 0;
        int k_count = 0;

        /** Should be rows and cols. */
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                Position position = new Position(i,j);
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

                double random = this.random.nextDouble();
                if (random < bushProbability) {
                    wm.setMap(position, WorldSpaceCreator.create("Bush"));
                    b_count++;
                } else if (random < caveProbability) {
                    wm.setMap(position, WorldSpaceCreator.create("Cave"));
                    c_count++;
                } else if (random < koulouProbability) {
                    wm.setMap(position, WorldSpaceCreator.create("Koulou"));
                    k_count++;
                } else {
                    wm.setMap(position, WorldSpaceCreator.create("Plain"));
                    plains.add(new Position(i,j));
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
