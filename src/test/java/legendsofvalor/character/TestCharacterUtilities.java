package legendsofvalor.character;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import legendsofvalor.item.Weapon;

public class TestCharacterUtilities {
    @Test
    public void TestName() {
        Name n1 = new Name("Hero1");

        Assertions.assertEquals(n1.get(), "Hero1");

        n1.set("Hero2");

        Assertions.assertEquals(n1.get(), "Hero2");
    }

    @Test
    public void TestLevel() {
        Level l1 = new Level(100);
        Level l2 = new Level();

        Assertions.assertEquals(l1.get(), 100);
        Assertions.assertEquals(l2.get(), 0);

        l1.set(11);
        l2.set(11);
        Assertions.assertEquals(l1.get(), 11);
        Assertions.assertEquals(l2.get(), 11);

        l1.set(-1);
        Assertions.assertEquals(11, l1.get());

    }

    @Test
    public void TestGold() {
        Gold g1 = new Gold(100);
        Gold g2 = new Gold();

        Assertions.assertEquals(g1.get(), 100);
        Assertions.assertEquals(g2.get(), 0);

        g1.increase(11);
        g2.decrease(6);

        Assertions.assertEquals(g1.get(), 111);
        Assertions.assertEquals(g2.get(), 0);

        g1.decrease(100);
        Assertions.assertEquals(g1.get(), 11);

        g1.decrease(100);
        Assertions.assertEquals(g1.get(), 0);

        g2.increase(5);

        Assertions.assertTrue(g2.isGoldEnough(4));
        Assertions.assertTrue(g2.isGoldEnough(5));
        Assertions.assertFalse(g2.isGoldEnough(6));

    }

    @Test
    public void TestHP() {
        HP hp1 = new HP(100);
        HP hp2 = new HP();

        Assertions.assertEquals(hp1.get(), 100);
        Assertions.assertEquals(hp2.get(), 0);

        hp1.increase(10);
        hp2.increase(10111);

        Assertions.assertEquals(hp1.get(), 110);
        Assertions.assertEquals(hp2.get(), 10111);

        hp1.increase(-10);
        hp2.increase(-10111);

        Assertions.assertEquals(hp1.get(), 110);
        Assertions.assertEquals(hp2.get(), 10111);

        hp1.decrease(10);
        hp2.decrease(10111);

        Assertions.assertEquals(hp1.get(), 100);
        Assertions.assertEquals(hp2.get(), 0);

        hp1.decrease(100);
        Assertions.assertEquals(hp1.get(), 0);

    }

    @Test
    public void TestAgility() {
        Agility a1 = new Agility(25);
        Agility a2 = new Agility();
        Agility a3 = new Agility(100);

        Assertions.assertEquals(a1.get(), 25);
        Assertions.assertEquals(a2.get(), 0);
        Assertions.assertEquals(a3.get(), 100);

        a1.set(1000);
        a2.set(5000);
        a3.set(0);
        Assertions.assertEquals(a1.get(), 1000);
        Assertions.assertEquals(a2.get(), 5000);
        Assertions.assertEquals(a3.get(), 0);

        int count = 0;
        for (int i = 0; i < 100; i++) {
            if (a1.isDodge()) {
                count++;
            }
        }

        Assertions.assertTrue(12 < count && count < 28);

        count = 0;
        for (int i = 0; i < 100; i++) {
            if (a2.isDodge()) {
                count++;
            }
        }
        Assertions.assertEquals(100, count);

        count = 0;
        for (int i = 0; i < 100; i++) {
            if (a3.isDodge()) {
                count++;
            }
        }
        Assertions.assertEquals(0, count);
    }

    @Test
    public void TestDefense() {
        Defense d1 = new Defense(100);
        Defense d2 = new Defense();

        Assertions.assertEquals(d1.get(), 100);
        Assertions.assertEquals(d2.get(), 0);

        d1.set(-11);
        d2.set(11);
        Assertions.assertEquals(d1.get(), 100);
        Assertions.assertEquals(d2.get(), 11);

        d1.set(0);
        Assertions.assertEquals(d1.get(), 0);

    }

    @Test
    public void TestStrength() {
        Strength s1 = new Strength(100);
        Strength s2 = new Strength();

        Assertions.assertEquals(s1.get(), 100);
        Assertions.assertEquals(s2.get(), 0);

        s1.set(-11);
        s2.set(11);
        Assertions.assertEquals(s1.get(), 100);
        Assertions.assertEquals(s2.get(), 11);

        s1.set(0);
        Assertions.assertEquals(s1.get(), 0);
    }

    @Test
    public void TestDexterity() {
        Dexterity d1 = new Dexterity(100);
        Dexterity d2 = new Dexterity();

        Assertions.assertEquals(d1.get(), 100);
        Assertions.assertEquals(d2.get(), 0);

        d1.set(-11);
        d2.set(11);
        Assertions.assertEquals(d1.get(), 100);
        Assertions.assertEquals(d2.get(), 11);

        d1.set(0);
        Assertions.assertEquals(d1.get(), 0);
    }

    @Test
    public void TestMP() {
        MP mp1 = new MP(20);
        Assertions.assertEquals(mp1.get(), 20);
        mp1.set(0);
        Assertions.assertEquals(mp1.get(), 0);
        mp1.decrease(6);
        Assertions.assertEquals(mp1.get(), 0);
        mp1.increase(6);
        Assertions.assertEquals(mp1.get(), 6);
    }

    @Test
    public void TestDamage() {
        Damage d1 = new Damage(10);
        Damage d2 = new Damage();

        Assertions.assertEquals(d1.get(), 10);
        Assertions.assertEquals(d2.get(), 0);
    }

    @Test
    public void TestEquipptedWeapon() {
        EquippedWeaponList ew1 = new EquippedWeaponList();

        ew1.add(new Weapon("Sword A", 3, 13, 10, 10, 1));
        ew1.add(new Weapon("Sword B", 3, 13, 10, 10, 1));

        Assertions.assertEquals(ew1.get(0).getName(), "Sword A");
        Assertions.assertEquals(ew1.get(1).getName(), "Sword B");

        ew1.remove(0);
        Assertions.assertEquals(ew1.get(0).getName(), "Sword B");

        ew1.remove(ew1.get(0));
        Assertions.assertEquals(ew1.size(), 0);
    }

}
