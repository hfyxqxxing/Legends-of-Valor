package legendsofvalor.world;


import legendsofvalor.character.Hero;
import legendsofvalor.character.Monster;

import java.util.ArrayList;
import java.util.Collections;

public class WorldMap {
    private int rows;
    private int cols;

    private static WorldMap instance = null;
    private WorldCell[][] map;
    private ArrayList<Hero> Heroes;
    private ArrayList<Monster> Monsters;

    private WorldMap(int row, int col) {
        this.rows = row;
        this.cols = col;
        this.map = new WorldCell[row][col];
        Heroes = new ArrayList<>();
        Monsters = new ArrayList<>();
    }

    /**Strange */
    public static WorldMap getInstance() {
        if (instance == null){
            instance = new WorldMap(8,8);
        }
        return instance;
    }

    /**The touchable characters*/
    public ArrayList<Monster> getAttackScope(Hero hero){
        ArrayList<Monster> result = new ArrayList<>();
        ArrayList<AccessibleCell> rangeCells = around(hero.getPosition());
        for (AccessibleCell c : rangeCells ) {
            if (c.hasMonster()){
                result.add(c.getMonster());
            }else {
                System.out.println("No monster here");
            }
        }
        return result;
    }

    public ArrayList<Hero> getAttackScope(Monster monster){
        ArrayList<Hero> result = new ArrayList<>();
        ArrayList<AccessibleCell> rangeCells = around(monster.getPosition());
        for (AccessibleCell c : rangeCells ) {
            if (c.hasHero()){
                result.add(c.getHero());
            }else {
                System.out.println("No hero here");
            }
        }
        return result;
    }


    /**Need testing*/
    public ArrayList<AccessibleCell> around(Position position){
        ArrayList<AccessibleCell> result = new ArrayList<>();
        int x = position.getX();
        int y = position.getY();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i ==0 && j ==0){
                    continue;
                }
                Position pos = new Position(x+i,y+i);
                if (getCell(pos) != null){
                    if (getCell(pos) instanceof AccessibleCell){
                        result.add((AccessibleCell) getCell(pos));
                    }else {
                        System.out.println("Inaccess");
                    }
                }
                System.out.println("outrange");
            }
        }
        return result;
    }

    /**目标英雄的上下左右是相邻的位置，不能比英雄前，直接舍弃up，同时排除了behind monster的位置，因为本线
     * 的英雄不可能在本线的monster后面，然后排查如果不在表格内放弃，是墙放弃，返回一个判断是否有英雄的位置列表
     * （也就left和behind或者right和behind了）。还是说八个方向都是adjacent？*/
    public ArrayList<Position> tel_adjaceny(Position position){
        ArrayList<Position> result = new ArrayList<>();
        int x = position.getX();
        int y = position.getY();
        ArrayList<Position> temp = new ArrayList<>();
        temp.add(new Position(x+1,y));
        temp.add(new Position(x,y-1));
        temp.add(new Position(x,y+1));
        for (Position p : temp) {
            if (getCell(p) != null){
                if (getCell(p).isAccessible()){
                    result.add(p);
                }else {
                    System.out.println("Inacess");
                }
            }else {
                System.out.println("outrange");
            }
        }
        return result;

    }


    /**Need test whether the position of hero will be changed during detection*/
    public Position canMoveTo(Hero hero, String direction){
        Position new_pos = directionStep(hero.getPosition(),direction);
        if (getCell(new_pos) == null){
            System.out.println("Outrange");
            return null;
        }
        if (!getCell(new_pos).isAccessible()){
            System.out.println("Wall");
            return null;
        } else {
            if (getCell(new_pos).hasHero()){
                System.out.println("Already a hero here");
                return null;
            }
            /**If the monster is in the same line, it cannot move forward*/
            if (direction.equalsIgnoreCase("Up")){
                int x = new_pos.getX();
                int y = new_pos.getY();
                for (int j = -1; j < 2; j++) {
                    Position mon_pos = new Position(x, y+j);
                    if (getCell(mon_pos) != null){
                        if (getCell(mon_pos).hasMonster()){
                            System.out.println("You must kill the enemy to move forward!");
                            return null;
                        }
                    }
                }

            }
        }
        return new_pos;
    }

    public Position directionStep(Position pos, String direction){
        Position new_pos = new Position(0,0);
        if (direction.equalsIgnoreCase("Up")){
            new_pos = pos.changeto(-1,0);
        } else if (direction.equalsIgnoreCase("Left")) {
            new_pos = pos.changeto(0,-1);
        } else if (direction.equalsIgnoreCase("Right")) {
            new_pos = pos.changeto(0,1);
        } else if (direction.equalsIgnoreCase("Down")) {
            new_pos = pos.changeto(1,0);
        }
        return new_pos;

    }

    /**Has some question on choices*/
    public ArrayList<Position> canTeleport(Hero fromHero, Hero TargetHero){
        ArrayList<Position> possible = new ArrayList<>();
        int lane_from = getLane(fromHero.getPosition());
        int lane_to = getLane(TargetHero.getPosition());
        if (lane_from == lane_to){
            return null;
        }
        ArrayList<Position> adjency = tel_adjaceny(TargetHero.getPosition());
        for (Position p: adjency) {
            AccessibleCell c = (AccessibleCell) getCell(p);
            if (c.getHero() == null){
                possible.add(p);
            }
        }
        return possible;
    }

    /**return 0, game is not over*/
    public int checkWin(){
        for (Hero h: Heroes) {
            if (isInNexusMonster(h.getPosition())){
                return 1;
            }
        }
        for (Monster m : Monsters) {
            if (isInNexusHero(m.getPosition())){
                return -1;
            }
        }
        return 0;
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

    public ArrayList<Hero> getHeroes() {
        return Heroes;
    }

    public void setHeroes(ArrayList<Hero> heroes) {
        Heroes = heroes;
    }

    public boolean register(Hero h){
        if (Heroes.size() == 3){
            System.out.println("Already full");
            return false;
        }
        Heroes.add(h);
        return true;
    }

    public boolean register(Hero h,Position position){
        if (Heroes.size() == 3){
            System.out.println("Already full");
            return false;
        }
        h.setPosition(position);
        Heroes.add(h);
        return true;
    }

    public Position getHeroInitPosition(int lane){
        if(lane*3 < cols && lane >= 0 ){
            return new Position(rows,lane*3);
        }else {
            System.out.println("No such lane nexus");
            return null;
        }
    }

    public Position getMonsterInitPosition(int lane){
        if(lane*3 < cols && lane >= 0 ){
            return new Position(0,lane*3);
        }else {
            System.out.println("No such lane monster nexus");
            return null;
        }
    }

    public ArrayList<Monster> getMonsters() {
        return Monsters;
    }

    public void register(Monster m){
        System.out.println("One monster generated");
        Monsters.add(m);
    }

    public void setMonsters(ArrayList<Monster> monsters) {
        Monsters = monsters;
    }

    public void setMap(Position position, WorldCell value) {
        int x = position.getX();
        int y = position.getY();
        if (x >= this.rows || y >= this.cols || x < 0 || y < 0)
            return;
        this.map[x][y] = value;
    }

    /**Eliminate the outrange values*/
    public WorldCell getCell(Position position){
        int x = position.getX();
        int y = position.getY();
        if (x < 0 || x > rows){
            return null;
        }else if(y < 0 || y > cols){
            return null;
        }
        return map[x][y];
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


    public boolean isInNexusHero(Position position) {
        return map[position.getX()][position.getY()].getSymbol() == ('N');
    }

    public boolean isInNexusMonster(Position position){
        return map[position.getX()][position.getY()].getSymbol() == ('M');
    }

    /** Need changes */
    public String toString(Position position_hero) {
        String re = "";
        re += "+" + String.join("", Collections.nCopies(this.rows, "---+")) + "\n";
        for (int i = 0; i < this.cols; i++) {
            re += "|";
            for (int j = 0; j < this.rows; j++) {
                if (i == position_hero.getX() && j == position_hero.getY()) {
                    re += "*H*|";
                } else {
                    re += " " + this.map[i][j].getSymbol() + " |";
                }

            }
            re += "\n";
            re += "+" + String.join("", Collections.nCopies(this.rows, "---+")) + "\n";
        }
        if (isInNexusHero(position_hero)) {
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
        int who = WorldMap.getInstance().checkWin();
        System.out.println(who);
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
