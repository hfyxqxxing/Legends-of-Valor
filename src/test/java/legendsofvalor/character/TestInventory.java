package legendsofvalor.character;

import org.junit.jupiter.api.Test;

import legendsofvalor.item.Armor;

// import legendsofvalor.item.SpellTypeCreator;
import legendsofvalor.item.Weapon;

public class TestInventory {
    @Test
    public void TestMarketOutput() {
        Inventory inv = new Inventory();
        // String expectedInventory = "\n <Armor> Defense \n
        // -------------------------------\n[0] Shield A 60 \n[1] Shield B 60 \n[2]
        // Shield C 60 \n[3] Shield D 60 \n[4] Shield B 80 \n\n <Potion> Power Up Boosts
        // \n ------------------------------------------\n[5] Health 50 [HP,
        // Strength]\n\n <Spell> Damage ManaCost SpellType Used/Quantity\n
        // -------------------------------------------------------------------\n[6]
        // Fireball 60 1 Fire 0/10 \n\n <Weapon> Damage Hands \n
        // ------------------------------------------\n[7] Sword A 10 1 \n[8] Sword B
        // 100 1 \n[9] Sword C 100 1 \n[10] Sword D 100 1 \n[11] Sword C 1000 10 \n";

        inv.addItem(new Weapon("Sword A", 3, 13, 10, 10, 1));
        inv.addItem(new Weapon("Sword B", 4, 16, 10, 100, 1));
        inv.addItem(new Weapon("Sword C", 4, 16, 10, 100, 1));
        inv.addItem(new Weapon("Sword D", 4, 16, 10, 100, 1));

        inv.addItem(new Armor("Shield A", 0, 100, 90, 60));
        inv.addItem(new Armor("Shield B", 0, 100, 90, 60));
        inv.addItem(new Armor("Shield C", 0, 100, 90, 60));
        inv.addItem(new Armor("Shield D", 0, 100, 90, 60));

        // Potion p = new Potion("Health", 1, 100, 90, 50);
        // p.addBoost("HP");
        // p.addBoost("Strength");
        // inv.addItem(p);

        // inv.addItem(new Spell("Fireball", 1, 100, 90, 60, 1, 10, SpellTypeCreator.create("Fire")));

        // inv.addItem(new Armor("Shield B", 2, 12, 9, 80));

        // inv.addItem(new Weapon("Sword C", 10, 19, 10, 1000, 10));

        // System.out.println(inv);
        // Assertions.assertEquals(expectedInventory, inv.toString());
    }
}
