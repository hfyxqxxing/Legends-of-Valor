package legendsofvalor.character;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCharacter {
    @Test
    public void TestMonsterCreation() {
        Monster m1 = new Monster(new Name("Monster 1"), new HP(100), new Level(1), new Damage(15), new Defense(10), new Agility(15), "Dragon");

        Assertions.assertEquals(m1.getName().get(), "Monster 1");
        Assertions.assertEquals(m1.getHP().get(), 100);
        Assertions.assertEquals(m1.getLevel().get(), 1);
        Assertions.assertEquals(m1.getDamage().get(), 15);
        Assertions.assertEquals(m1.getDefense().get(), 10);
        Assertions.assertEquals(m1.getAgility().get(), 15);
        Assertions.assertEquals(m1.getMonsterType(), "Dragon");

        m1.getAgility().set(1000);
        Assertions.assertEquals(m1.getAgility().get(), 1000);

        int count = 0;
        for (int i = 0; i < 100; i++) {
            if (m1.getAgility().isDodge()) {
                count++;
            }
        }
        Assertions.assertTrue(12 < count && count < 28);

        // System.out.println(m1.getHeader());
        // System.out.println(m1.getBody());
        String expectedHeader = "[Type] Name               Level      HP         Damage     Defense    Agility   ";
        String expectedBody = "[Dragon] Monster 1        1          100        15         10         1000      ";

        // Assertions.assertEquals(expectedHeader, m1.getHeader());
        Assertions.assertEquals(expectedBody, m1.getBody());

    }

}
