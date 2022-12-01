/*
 * We use the adapter pattern to retrive the configuration informations
 * In this homework, the configs are stored in txt files.
 */

package legendsofvalor.utils;

import java.util.ArrayList;

import legendsofvalor.character.*;
import legendsofvalor.item.*;

public class ConfigurationAdaptor {
    private static ConfigurationAdaptor instance = null;
    private ArrayList<Hero> Heroes;
    private ArrayList<Monster> Monsters;
    private ArrayList<Weapon> Weapons;
    private ArrayList<Spell> Spells;
    private ArrayList<Armor> Armors;
    private ArrayList<Potion> Potions;
    private double battleProbability;

    private ConfigurationAdaptor() {
        Heroes = new ArrayList<Hero>();
        Monsters = new ArrayList<Monster>();
        Weapons = new ArrayList<Weapon>();
        Spells = new ArrayList<Spell>();
        Armors = new ArrayList<Armor>();
        Potions = new ArrayList<Potion>();
        battleProbability = 0.2;
    }

    public static ConfigurationAdaptor getInstance() {
        if (instance == null) {
            instance = new ConfigurationAdaptor();
            instance.load();
        }
        return instance;
    }

    private void load() {
        loadHero();
        loadMonster();
        loadWeapon();
        loadArmor();
        loadPotion();
        loadSpell();
    }

    private void loadHero() {
        // load warrior
        Heroes.add(new WarriorHero("Gaerdal_Ironhand", 100, 1, 44, 700, 100, 600, 500, 12350, 4, 7));
        Heroes.add(new WarriorHero("Sehanine_Monnbow", 100, 1, 23, 700, 600, 500, 9999, 25000, 2, 8));
        Heroes.add(new WarriorHero("Muamman_Duathall", 100, 1, 34, 900, 300, 750, 750, 25000, 2, 6));
        Heroes.add(new WarriorHero("Flandal_Steelskin", 100, 1, 35, 750, 200, 700, 650, 25000, 2, 7));
        Heroes.add(new WarriorHero("Undefeated_Yoj", 100, 1, 36, 800, 400, 700, 400, 25000, 2, 7));
        Heroes.add(new WarriorHero("Eunoia_Cyn", 100, 1, 37, 700, 400, 600, 800, 25000, 2, 6));
        // load sorcerer
        Heroes.add(new SorcererHero("Rillifane_Rallathil", 100, 1, 22, 750, 1300, 500, 450, 2500, 1, 9));
        Heroes.add(new SorcererHero("Segojan_Earthcaller", 100, 1, 22, 800, 900, 650, 500, 2500, 2, 5));
        Heroes.add(new SorcererHero("Reign_Havoc", 100, 1, 23, 800, 800, 800, 800, 2500, 2, 8));
        Heroes.add(new SorcererHero("Reverie_Ashels", 100, 1, 23, 800, 900, 400, 700, 2500, 2, 7));
        Heroes.add(new SorcererHero("Kalabar", 100, 1, 24, 850, 800, 600, 400, 2500, 2, 6));
        Heroes.add(new SorcererHero("Skye_Soar", 100, 1, 21, 700, 1000, 500, 400, 2500, 2, 5));
        // load paladin
        Heroes.add(new PaladinHero("Parzival", 100, 1, 24, 750, 300, 700, 650, 2500, 2, 7));
        Heroes.add(new PaladinHero("Sehanine_Moonbow", 100, 1, 25, 750, 300, 700, 700, 2500, 2, 7));
        Heroes.add(new PaladinHero("Skoraeus_Stonebones", 100, 1, 26, 650, 250, 350, 600, 2500, 2, 4));
        Heroes.add(new PaladinHero("Garl_Glittergold", 100, 1, 20, 300, 100, 400, 500, 2500, 2, 5));
        Heroes.add(new PaladinHero("Amaryllis_Astra", 100, 1, 20, 200, 500, 500, 500, 2500, 2, 5));
        Heroes.add(new PaladinHero("Caliber_Heist", 100, 1, 20, 100, 400, 400, 400, 2500, 2, 8));
    }

    private void loadMonster() {
        // load dragon
        Monsters.add(new DragonMonster("Desghidorrah", 300, 8, 400, 40, 35));
        Monsters.add(new DragonMonster("Chrysophylax", 200, 6, 500, 50, 20));
        Monsters.add(new DragonMonster("BunsenBurner", 400, 4, 500, 50, 45));
        Monsters.add(new DragonMonster("Natsunomeryu", 100, 3, 200, 20, 10));
        Monsters.add(new DragonMonster("TheScaleless", 700, 7, 600, 60, 75));
        Monsters.add(new DragonMonster("Kas-Ethelinh", 500, 9, 500, 50, 60));
        Monsters.add(new DragonMonster("Alexstraszan", 1000, 8, 900, 90, 55));
        Monsters.add(new DragonMonster("Phaarthurnax", 600, 6, 700, 70, 60));
        Monsters.add(new DragonMonster("D-Maleficent ", 900, 9, 950, 95, 85));
        Monsters.add(new DragonMonster("TheWeatherbe", 800, 8, 900, 90, 80));
        Monsters.add(new DragonMonster("Igneel", 600, 6, 400, 40, 60));
        Monsters.add(new DragonMonster("BlueEyesWhite", 900, 9, 600, 60, 75));
        // load exoskeleton
        Monsters.add(new ExoskeletonMonster("Cyrrollalee", 700, 7, 700, 80, 75));
        Monsters.add(new ExoskeletonMonster("Brandobaris", 300, 4, 350, 45, 30));
        Monsters.add(new ExoskeletonMonster("BigBad-Wolf", 100, 2, 150, 25, 15));
        Monsters.add(new ExoskeletonMonster("WickedWitch", 200, 3, 250, 35, 25));
        Monsters.add(new ExoskeletonMonster("Aasterinian", 400, 4, 400, 50, 45));
        Monsters.add(new ExoskeletonMonster("Chronepsish", 600, 7, 650, 70, 60));
        Monsters.add(new ExoskeletonMonster("Kiaransalee", 800, 8, 850, 95, 85));
        Monsters.add(new ExoskeletonMonster("St-Shargaas", 500, 8, 550, 65, 55));
        Monsters.add(new ExoskeletonMonster("Merrshaullk", 1000, 10, 1000, 90, 55));
        Monsters.add(new ExoskeletonMonster("St-Yeenoghu", 900, 9, 950, 85, 90));
        Monsters.add(new ExoskeletonMonster("DocOck", 600, 6, 600, 60, 55));
        Monsters.add(new ExoskeletonMonster("Exodia", 1000, 10, 1000, 100, 50));
        // load spirit
        Monsters.add(new SpiritMonster("Andrealphus", 500, 7, 600, 50, 40));
        Monsters.add(new SpiritMonster("Blinky", 100, 5, 450, 350, 35));
        Monsters.add(new SpiritMonster("Andromalius", 300, 4, 550, 45, 25));
        Monsters.add(new SpiritMonster("Chiang-shih", 400, 5, 700, 60, 40));
        Monsters.add(new SpiritMonster("FallenAngel", 500, 6, 800, 70, 50));
        Monsters.add(new SpiritMonster("Ereshkigall", 600, 6, 950, 45, 35));
        Monsters.add(new SpiritMonster("Melchiresas", 700, 8, 350, 15, 75));
        Monsters.add(new SpiritMonster("Jormunngand", 800, 8, 600, 90, 20));
        Monsters.add(new SpiritMonster("Rakkshasass", 900, 8, 550, 60, 35));
        Monsters.add(new SpiritMonster("Taltecuhtli", 1000, 10, 300, 20, 50));
        Monsters.add(new SpiritMonster("Casper", 100, 3, 100, 10, 50));

    }

    private void loadWeapon() {
        Weapons.add(new Weapon("Sword", 1, 500, 250, 1000, 1));
        Weapons.add(new Weapon("Sword", 1, 600, 300, 1500, 1));
        Weapons.add(new Weapon("Sword", 2, 700, 350, 2000, 1));
        Weapons.add(new Weapon("Sword", 3, 800, 400, 3000, 1));
        Weapons.add(new Weapon("Bow", 1, 300, 150, 500, 2));
        Weapons.add(new Weapon("Bow", 1, 400, 200, 100, 2));
        Weapons.add(new Weapon("Bow", 2, 500, 250, 2000, 2));
        Weapons.add(new Weapon("Bow", 3, 600, 300, 3000, 2));
        Weapons.add(new Weapon("Scythe", 1, 1000, 500, 1100, 2));
        Weapons.add(new Weapon("Scythe", 1, 2000, 1000, 1500, 2));
        Weapons.add(new Weapon("Axe", 1, 500, 250, 850, 1));
        Weapons.add(new Weapon("Axe", 2, 600, 300, 100, 1));
        Weapons.add(new Weapon("TSwords", 2, 1400, 700, 2600, 2));
        Weapons.add(new Weapon("TSwords", 2, 2000, 1000, 4000, 2));
        Weapons.add(new Weapon("Dagger", 1, 200, 100, 250, 1));
        Weapons.add(new Weapon("Dagger", 1, 400, 200, 400, 1));
    }

    private void loadArmor() {
        Armors.add(new Armor("Platinum_Shield", 1, 150, 75, 200));
        Armors.add(new Armor("Breastplate", 1, 350, 175, 600));
        Armors.add(new Armor("Full_Body_Armor", 1, 800, 400, 800));
        Armors.add(new Armor("Full_Body_Armor", 2, 1000, 500, 1100));
        Armors.add(new Armor("Wizard_Shield", 3, 1200, 600, 1500));
        Armors.add(new Armor("Wizard_Shield", 2, 1000, 500, 1000));
        Armors.add(new Armor("Wizard_Shield", 1, 800, 400, 500));
        Armors.add(new Armor("Guardian_Angel", 1, 1000, 500, 1000));
    }

    private void loadPotion() {
        Potions.add(PotionCreator.create("Healing_Potion", 1, 250, 125, 100, "HP"));
        Potions.add(PotionCreator.create("Strength_Potion", 1, 200, 100, 75, "Strength"));
        Potions.add(PotionCreator.create("Magic_Potion", 1, 350, 175, 100, "MP"));
        Potions.add(PotionCreator.create("Luck_Elixir", 1, 400, 200, 50, "Agility"));
        Potions.add(PotionCreator.create("Luck_Elixir", 2, 500, 250, 65, "Agility"));
        Potions.add(PotionCreator.create("Mermaid_Tears", 1, 500, 250, 80, "HP/MP/Strength/Agility"));
        Potions.add(PotionCreator.create("Mermaid_Tears", 2, 850, 425, 100, "HP/MP/Strength/Agility"));
        Potions.add(PotionCreator.create("Ambrosia", 1, 500, 250, 100, "HP/MP/Strength/Dexterity/Defense/Agility"));
        Potions.add(PotionCreator.create("Ambrosia", 2, 800, 400, 120, "HP/MP/Strength/Dexterity/Defense/Agility"));
        Potions.add(PotionCreator.create("Ambrosia", 3, 1000, 500, 150, "HP/MP/Strength/Dexterity/Defense/Agility"));
        Potions.add(PotionCreator.create("Revival", 3, 1000, 500, 150, "Revival"));
        Potions.add(PotionCreator.create("Healing_Potion", 1, 300, 125, 100, "HP"));
        Potions.add(PotionCreator.create("Strength_Potion", 1, 250, 100, 75, "Strength"));
        Potions.add(PotionCreator.create("Magic_Potion", 1, 325, 175, 100, "MP"));
        Potions.add(PotionCreator.create("Luck_Elixir", 1, 410, 200, 50, "Agility"));
        Potions.add(PotionCreator.create("Luck_Elixir", 2, 520, 250, 65, "Agility"));
        Potions.add(PotionCreator.create("Mermaid_Tears", 1, 530, 250, 80, "HP/MP/Strength/Agility"));
        Potions.add(PotionCreator.create("Mermaid_Tears", 2, 820, 425, 100, "HP/MP/Strength/Agility"));
        Potions.add(PotionCreator.create("Ambrosia", 1, 400, 250, 100, "HP/MP/Strength/Dexterity/Defense/Agility"));
        Potions.add(PotionCreator.create("Ambrosia", 2, 700, 400, 120, "HP/MP/Strength/Dexterity/Defense/Agility"));
        Potions.add(PotionCreator.create("Ambrosia", 3, 1100, 500, 150, "HP/MP/Strength/Dexterity/Defense/Agility"));
        Potions.add(PotionCreator.create("Revival", 3, 1100, 500, 150, "Revival"));
    }

    private void loadSpell() {
        // load ice spell
        Spells.add(SpellCreator.create("Ice", "Snow_Cannon", 1, 500, 250, 650, 25, 5));
        Spells.add(SpellCreator.create("Ice", "Ice_Blade", 1, 250, 125, 460, 10, 5));
        Spells.add(SpellCreator.create("Ice", "Frost_Blizzard", 1, 750, 375, 850, 35, 5));
        Spells.add(SpellCreator.create("Ice", "Arctic_Storm", 2, 700, 350, 800, 30, 5));
        // load fire spell
        Spells.add(SpellCreator.create("Fire", "Flame_Tornado", 1, 700, 350, 850, 30, 5));
        Spells.add(SpellCreator.create("Fire", "Breath_of_Fire", 1, 350, 175, 450, 10, 5));
        Spells.add(SpellCreator.create("Fire", "Heat_Wave", 1, 450, 225, 600, 15, 5));
        Spells.add(SpellCreator.create("Fire", "Lava_Comet", 3, 800, 400, 1000, 10, 5));
        Spells.add(SpellCreator.create("Fire", "Hell_Storm", 2, 600, 300, 950, 95, 5));
        // load lightning spell
        Spells.add(SpellCreator.create("Lightning", "Lightning_Dagger", 1, 400, 200, 500, 15, 5));
        Spells.add(SpellCreator.create("Lightning", "Thunder_Blast", 1, 750, 375, 950, 40, 5));
        Spells.add(SpellCreator.create("Lightning", "Electric_Arrows", 3, 550, 225, 650, 20, 5));
        Spells.add(SpellCreator.create("Lightning", "Spark_Needles", 2, 500, 250, 600, 20, 5));

        // repeat
        // load ice spell
        Spells.add(SpellCreator.create("Ice", "Snow_Cannon", 1, 500, 250, 650, 25, 5));
        Spells.add(SpellCreator.create("Ice", "Ice_Blade", 1, 250, 125, 460, 10, 5));
        Spells.add(SpellCreator.create("Ice", "Frost_Blizzard", 1, 750, 375, 850, 35, 5));
        Spells.add(SpellCreator.create("Ice", "Arctic_Storm", 2, 700, 350, 800, 30, 5));
        // load fire spell
        Spells.add(SpellCreator.create("Fire", "Flame_Tornado", 1, 700, 350, 850, 30, 5));
        Spells.add(SpellCreator.create("Fire", "Breath_of_Fire", 1, 350, 175, 450, 10, 5));
        Spells.add(SpellCreator.create("Fire", "Heat_Wave", 1, 450, 225, 600, 15, 5));
        Spells.add(SpellCreator.create("Fire", "Lava_Comet", 3, 800, 400, 1000, 10, 5));
        Spells.add(SpellCreator.create("Fire", "Hell_Storm", 2, 600, 300, 950, 95, 5));
        // load lightning spell
        Spells.add(SpellCreator.create("Lightning", "Lightning_Dagger", 1, 400, 200, 500, 15, 5));
        Spells.add(SpellCreator.create("Lightning", "Thunder_Blast", 1, 750, 375, 950, 40, 5));
        Spells.add(SpellCreator.create("Lightning", "Electric_Arrows", 3, 550, 225, 650, 20, 5));
        Spells.add(SpellCreator.create("Lightning", "Spark_Needles", 2, 500, 250, 600, 20, 5));
    }

    public ArrayList<Hero> getHeroes() {
        return Heroes;
    }

    public ArrayList<Monster> getMonsters() {
        return Monsters;
    }

    public ArrayList<Weapon> getWeapons() {
        return Weapons;
    }

    public ArrayList<Armor> getArmors() {
        return Armors;
    }

    public ArrayList<Potion> getPotions() {
        return Potions;
    }

    public ArrayList<Spell> getSpells() {
        return Spells;
    }

    public double getBattleProbability() {
        return battleProbability;
    }
}
