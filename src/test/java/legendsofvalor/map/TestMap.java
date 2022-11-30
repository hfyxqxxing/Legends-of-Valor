package legendsofvalor.map;

import legendsofvalor.character.DragonMonster;
import legendsofvalor.character.Hero;
import legendsofvalor.character.Monster;
import legendsofvalor.character.WarriorHero;
import legendsofvalor.utils.InputCheck;
import legendsofvalor.world.AccessibleCell;
import legendsofvalor.world.Position;
import legendsofvalor.world.WorldMap;
import legendsofvalor.world.WorldMapCreator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

public class TestMap {

    @Test
    public void TestMapCreator() {
        double[] input = {0.2, 0.2, 0.2};
        WorldMapCreator wm = new WorldMapCreator(8, 8, input[0], input[1], input[2], 2);
        WorldMap m = wm.create();
        Hero h = new WarriorHero("Gaerdal_Ironhand", 100, 1, 44, 700, 100, 600, 500, 12350, 4, 7);
        Monster monster = new DragonMonster("Desghidorrah", 300, 8, 400, 40, 35);
        m.register(h, new Position(7, 0));
        m.register(monster, new Position(0, 0));
        System.out.println(m);
    }

    @Test
    public void TestAround() {
        double[] input = {0.2, 0.2, 0.2};
        WorldMapCreator wm = new WorldMapCreator(8, 8, input[0], input[1], input[2], 2);
        WorldMap m = wm.create();
        Hero h = new WarriorHero("Gaerdal_Ironhand", 100, 1, 44, 700, 100, 600, 500, 12350, 4, 7);
        Monster monster = new DragonMonster("Desghidorrah", 300, 8, 400, 40, 35);
        m.register(h, new Position(3, 0));
        m.register(monster, new Position(3, 1));
        System.out.println(m);
        ArrayList<AccessibleCell> rounds = m.around(h.getPosition());
        for (int i = 0; i < rounds.size(); i++) {
            System.out.println(rounds.get(i));
        }
    }


    @Test
    public void TestAttackScope() {
        double[] input = {0.2, 0.2, 0.2};
        WorldMapCreator wm = new WorldMapCreator(8, 8, input[0], input[1], input[2], 2);
        WorldMap m = wm.create();
        Hero h = new WarriorHero("Gaerdal_Ironhand", 100, 1, 44, 700, 100, 600, 500, 12350, 4, 7);
        Hero h2 = new WarriorHero("Gaerdal_Ironhand2", 100, 1, 44, 700, 100, 600, 500, 12350, 4, 7);
        Monster monster = new DragonMonster("Desghidorrah", 300, 8, 400, 40, 35);
        Monster monster2 = new DragonMonster("Desghidorrah2", 300, 8, 400, 40, 35);
        Monster monster3 = new DragonMonster("Desghidorrah3", 300, 8, 400, 40, 35);
        Monster monster4 = new DragonMonster("Desghidorrah4", 300, 8, 400, 40, 35);
        m.register(h2, new Position(4, 3));
        m.register(h, new Position(3, 0));
        m.register(monster, new Position(3, 1));
        m.register(monster3, new Position(3, 3));
        m.register(monster4, new Position(4, 3));
        m.register(monster2, new Position(3, 0));
        System.out.println(m);
        ArrayList<Monster> rounds = m.getAttackScope(h2);
        for (int i = 0; i < rounds.size(); i++) {
            System.out.println(rounds.get(i));
        }
        ArrayList<Hero> m_rounds = m.getAttackScope(monster2);
        System.out.println(m_rounds.get(0));
        ArrayList<Hero> m_rounds2 = m.getAttackScope(monster3);
        System.out.println(m_rounds2.get(0));
    }

    @Test
    public void TestCanMove() {
        double[] input = {0.2, 0.2, 0.2};
        WorldMapCreator wm = new WorldMapCreator(8, 8, input[0], input[1], input[2], 2);
        WorldMap m = wm.create();
        Hero h = new WarriorHero("Gaerdal_Ironhand", 100, 1, 44, 700, 100, 600, 500, 12350, 4, 7);
        Monster monster = new DragonMonster("Desghidorrah", 300, 8, 400, 40, 35);
        m.register(h, new Position(3, 1));
        m.register(monster, new Position(0, 1));
        System.out.println(m);
        Position next = m.canMoveTo(h, "Up");
        if (next == null) {
            System.out.println("Not available");
        } else {
            System.out.println("Up:" + next);
        }
        next = m.canMoveTo(h, "Left");
        if (next == null) {
            System.out.println("Not available");
        } else {
            System.out.println("Left" + next);
        }
        next = m.canMoveTo(h, "Right");
        if (next == null) {
            System.out.println("Not available");
        } else {
            System.out.println("Right" + next);
        }
        next = m.canMoveTo(h, "Down");
        if (next == null) {
            System.out.println("Not available");
        } else {
            System.out.println("Down" + next);
        }
    }

    @Test
    public void TestMove() {
        double[] input = {0.2, 0.2, 0.2};
        WorldMapCreator wm = new WorldMapCreator(8, 8, input[0], input[1], input[2], 2);
        WorldMap m = wm.create();
        Hero h = new WarriorHero("Gaerdal_Ironhand", 100, 1, 44, 700, 100, 600, 500, 12350, 4, 7);
        Monster monster = new DragonMonster("Desghidorrah", 300, 8, 400, 40, 35);
        m.register(h, new Position(4, 0));
        m.register(monster, new Position(3, 1));
        System.out.println(m);
        Position newone = m.canMoveTo(h, "Up");
        if (newone != null) {
            m.MoveTo(h, newone);
        }
        Position m_one = m.canMoveTo(monster);
        if (m_one != null) {
            m.MoveTo(monster, m_one);
        }
        System.out.println(m);
        Position newone2 = m.canMoveTo(h, "Up");
        if (newone2 != null) {
            m.MoveTo(h, newone2);
        }
        System.out.println(m);
        System.out.println(m.getAccessibleCell(new Position(3, 0)));
        System.out.println(m.getAccessibleCell(new Position(3, 1)));
    }
}
