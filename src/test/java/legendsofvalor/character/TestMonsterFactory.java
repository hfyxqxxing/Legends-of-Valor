package legendsofvalor.character;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMonsterFactory {
    @Test
    public void TestMonsterFactory1() {
        Monster m = MonsterFactory.create(3);
        Assertions.assertEquals(m.getLevel().get(), 3);

        System.out.println(m.getHeader());
        System.out.println(m.getBody());

    }

}
