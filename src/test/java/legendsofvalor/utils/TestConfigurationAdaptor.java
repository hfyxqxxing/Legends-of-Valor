package legendsofvalor.utils;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import legendsofvalor.character.*;
import legendsofvalor.item.*;

public class TestConfigurationAdaptor {
    @Test
    public void TestConfigurationAdaptor1() {
        ConfigurationAdaptor adaptor = ConfigurationAdaptor.getInstance();
        ArrayList<Hero> heros = adaptor.getHeroes();
        ArrayList<Monster> monsters = adaptor.getMonsters();
        ArrayList<Weapon> weapons = adaptor.getWeapons();
        ArrayList<Spell> spells = adaptor.getSpells();
        ArrayList<Armor> armors = adaptor.getArmors();
        ArrayList<Potion> potions = adaptor.getPotions();

        Assertions.assertEquals(heros.size(), 18);
        // System.out.println(heros.get(0));

        Assertions.assertEquals(monsters.size(), 35);

        Assertions.assertEquals(weapons.size(), 16);

        Assertions.assertEquals(armors.size(), 8);

        // Assertions.assertEquals(potions.size(), 10);

        // Assertions.assertEquals(spells.size(), 13);

        // Assertions.assertEquals("[Health, Mana, Strength, Agility]", potions.get(5).getBoosts().toString());
        // Assertions.assertEquals("[Agility]", potions.get(4).getBoosts().toString());
        // Assertions.assertEquals("[Agility]", potions.get(3).getBoosts().toString());

    }

}
