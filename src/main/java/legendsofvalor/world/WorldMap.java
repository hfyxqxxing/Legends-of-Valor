package legendsofvalor.world;


import javafx.geometry.Pos;
import legendsofvalor.character.DragonMonster;
import legendsofvalor.character.Hero;
import legendsofvalor.character.Monster;
import legendsofvalor.character.WarriorHero;
import legendsofvalor.utils.ColorPrint;
import legendsofvalor.utils.InputCheck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WorldMap {
    private int rows;
    private int cols;
    private WorldCell[][] map;
    private ArrayList<Hero> Heroes;
    private ArrayList<Monster> Monsters;

    public WorldMap(int row, int col) {
        this.rows = row;
        this.cols = col;
        this.map = new WorldCell[row][col];
        Heroes = new ArrayList<>();
        Monsters = new ArrayList<>();
    }



    /**The touchable characters*/
    public ArrayList<Monster> getAttackScope(Hero hero){
        ArrayList<Monster> result = new ArrayList<>();
        ArrayList<AccessibleCell> rangeCells = around(hero.getPosition());
        for (AccessibleCell c : rangeCells ) {
            if (c.hasMonster()){
                result.add(c.getMonster());
            }else {
//                System.out.println("No monster here");
            }
        }
        if (result.isEmpty()){
            System.out.println("There is no monster around the hero.");
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
//                System.out.println("No hero here");
            }
        }
        return result;
    }


    /**Tested*/
    public ArrayList<AccessibleCell> around(Position position){
        ArrayList<AccessibleCell> result = new ArrayList<>();
        int x = position.getX();
        int y = position.getY();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                Position pos = new Position(x+i,y+j);
                if (getAccessibleCell(pos) != null){
                    result.add(getAccessibleCell(pos));
                }else {
//                    System.out.println("outrange or inaccess");
                }
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
            if (getAccessibleCell(p) != null){
                result.add(p);
            }else {
                System.out.println("outrange or inaccess");
            }
        }
        return result;

    }

    /**Can be used as any permitted movement. teleport/recall/move*/
    public void MoveTo(Hero hero, Position next){
        Position old = hero.getPosition();
        hero.setPosition(next);
        getAccessibleCell(old).setHero(null);
        getAccessibleCell(next).setHero(hero);
    }

    public void MoveTo(Monster monster, Position next){
        Position old = monster.getPosition();
        monster.setPosition(next);
        getAccessibleCell(old).setMonster(null);
        getAccessibleCell(next).setMonster(monster);
    }

    /**If there is a monster ahead of it, or the hero is in same line. It should moveto itself.(Staying)*/
    public Position canMoveTo(Monster monster){
        Position new_pos = directionStep(monster.getPosition(),"Down");
        /**Only moves down, so it will not meet with the situation of wall or outrange*/
        if (getAccessibleCell(new_pos).hasMonster()){
            System.out.println("Already a Monster here");
            return monster.getPosition();
        }
        for (int j = -1; j < 2; j++) {
            Position temp = new Position(monster.getPosition().getX(),monster.getPosition().getY()+j);
            if (getAccessibleCell(temp).hasHero()){
                System.out.println("Movement stopped by a hero");
                return monster.getPosition();
            }
        }
        return new_pos;
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
                int x = hero.getPosition().getX();
                int y = hero.getPosition().getY();
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

    /**Has some question on choices. Not tested*/
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

    /**return 0 meaning game is not over*/
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
        if (Heroes.contains(h)){
            System.out.println("Already exist");
            return false;
        }
        h.setPosition(position);
        getAccessibleCell(position).setHero(h);
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
            return new Position(0,lane*3+1);
        }else {
            System.out.println("No such lane with monster nexus");
            return null;
        }
    }

    public ArrayList<Monster> getMonsters() {
        return Monsters;
    }

    public void register(Monster m){
        Monsters.add(m);
    }

    public void register(Monster m,Position pos){
        if (Monsters.contains(m)){
            System.out.println("Not avaialble");
            return;
        }
        m.setPosition(pos);
        getAccessibleCell(pos).setMonster(m);
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
    public AccessibleCell getAccessibleCell(Position position){
        int x = position.getX();
        int y = position.getY();
        if (x < 0 || x > rows){
            return null;
        }else if(y < 0 || y > cols){
            return null;
        } else if (y % 3 ==2) {
            return null;
        }
        return (AccessibleCell) map[x][y];
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

    public boolean Isherohere(int x, int y){
        Position pos = new Position(x,y);
        if (Heroes.isEmpty()){
            return false;
        }
        for (Hero h: Heroes) {
            if (h.getPosition().equals(pos)){
                return true;
            }
        }
        return false;
    }

    public boolean IsMonsterhere(int x, int y){
        Position pos = new Position(x,y);
        if (Monsters.isEmpty()){
            return false;
        }
        for (Monster m : Monsters) {
            if (m.getPosition().equals(pos)){
                return true;
            }
        }
        return false;
    }

    /** Need changes */
    public String toString() {
        String re = "";
        re+="L0:   X  L1:   X  L2: \n";
        for (int i = 0; i < this.cols; i++) {
            for (int j = 0; j < this.rows; j++) {
                boolean hashero = Isherohere(i,j);
                boolean hasmonster = IsMonsterhere(i,j);
                if (map[i][j].getSymbol()=='N'){
                    re+=ColorPrint.Nexuspanel(hashero,hasmonster);
                } else if (map[i][j].getSymbol()=='M') {
                    re+=ColorPrint.Nexuspanel(hashero,hasmonster);
                }else if (map[i][j].getSymbol()=='P') {
                    re+=ColorPrint.Plainpanel(hashero,hasmonster);
                }else if (map[i][j].getSymbol()=='B') {
                    re+=ColorPrint.Bushpanel(hashero,hasmonster);
                }else if (map[i][j].getSymbol()=='C') {
                    re+=ColorPrint.Cavepanel(hashero,hasmonster);
                }else if (map[i][j].getSymbol()=='K') {
                    re+=ColorPrint.Kouloupanel(hashero,hasmonster);
                }else if (map[i][j].getSymbol()=='W') {
                    re+=ColorPrint.Wallpanel(hashero,hasmonster);
                }
            }
            re+="   " + i+" \n";
        }
        re+=" 0  1  2  3  4  5  6  7 \n";
        re+="\n***";
        re+=ColorPrint.Plainpanel(false,false)+" is plain; ";
        re+=ColorPrint.Bushpanel(false,false)+" is bush; ";
        re+=ColorPrint.Cavepanel(false,false)+" is cave; ";
        re+=ColorPrint.Kouloupanel(false,false)+" is koulou; \n";


        return re;
    }

    /**Moved to TestMap*/
}
