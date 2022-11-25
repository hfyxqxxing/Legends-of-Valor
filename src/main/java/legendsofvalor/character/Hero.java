/*
 * This is the base class for any type of hero
 */
package legendsofvalor.character;

import legendsofvalor.item.Armor;
import legendsofvalor.utils.ColorPrint;

public class Hero extends Character {
    private Strength strength;
    private MP mp;
    private Dexterity dexterity;
    private Agility agility;
    private Gold gold;
    private Inventory inventory;
    private Hand hands;
    private Experience experience;
    private String heroType;
    private EquippedWeaponList equippedWeaponList;
    private Armor armor;

    public Hero(Name name, HP hp, Level level, Defense defense, Strength strength, MP mp, Dexterity dexterity, Agility agility, Gold gold, Hand hands, Experience experience, String heroType) {
        super(name, hp, level, defense);
        this.strength = strength;
        this.mp = mp;
        this.dexterity = dexterity;
        this.agility = agility;
        this.gold = gold;
        this.hands = hands;
        this.experience = experience;
        this.heroType = heroType;
        this.inventory = new Inventory();
        this.equippedWeaponList = new EquippedWeaponList();
        this.armor = null;
    }

    public Hero(String name, int hp, int level, int defense, int strength, int mp, int dexterity, int agility, int gold, int hands, int experience, String heroType) {
        this(new Name(name), new HP(hp), new Level(level), new Defense(defense), new Strength(strength), new MP(mp), new Dexterity(dexterity), new Agility(agility), new Gold(gold), new Hand(hands), new Experience(experience), heroType);
    }

    public Strength getStrength() {
        return strength;
    }

    public void setStrength(Strength strength) {
        this.strength = strength;
    }

    public MP getMP() {
        return mp;
    }

    public void setMP(MP mp) {
        this.mp = mp;
    }

    public Dexterity getDexterity() {
        return dexterity;
    }

    public void setDexterity(Dexterity dexterity) {
        this.dexterity = dexterity;
    }

    public Agility getAgility() {
        return agility;
    }

    public void setAgility(Agility agility) {
        this.agility = agility;
    }

    public Gold getGold() {
        return gold;
    }

    public void setGold(Gold gold) {
        this.gold = gold;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Hand getHands() {
        return hands;
    }

    public void setHands(Hand hands) {
        this.hands = hands;
    }

    public Experience getExperience() {
        return experience;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }

    public String getHeroType() {
        return heroType;
    }

    public void setHeroType(String heroType) {
        this.heroType = heroType;
    }

    public EquippedWeaponList getEquippedWeaponList() {
        return equippedWeaponList;
    }

    public void setEquippedWeaponList(EquippedWeaponList equippedWeaponList) {
        this.equippedWeaponList = equippedWeaponList;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Armor getArmor() {
        return armor;
    }

    public int getWeaponDamage() {
        return equippedWeaponList.getTotalDamage();
    }

    public int getAttackDamage() {
        return (int) ((getWeaponDamage() + strength.get()) * 0.05);
    }

    public void checkLevelUp() {
        if (experience.get() >= getLevel().get() * 10) {
            ColorPrint.green(getName().get() + " has leveled up!");
            experience.decrease(getLevel().get() * 10);
            this.levelUp();
        }
    }

    protected void levelUp() {
        if (this instanceof WarriorHero) {
            ((WarriorHero) this).levelUp();
        } else if (this instanceof SorcererHero) {
            ((SorcererHero) this).levelUp();
        } else if (this instanceof PaladinHero) {
            ((PaladinHero) this).levelUp();
        }
    }

    public String attack(Monster monster) {
        if (monster == null) {
            return "";
        }
        if (monster.getAgility().isDodge()) {
            return monster.getName().get() + " dodged the attack!";
        }
        int damage = this.getAttackDamage() - monster.getDefense().get();
        if (damage < 0) {
            damage = 0;
        }
        monster.getHP().decrease(damage);
        String re = this.getName().get() + " attacks " + monster.getName().get() + " for " + damage + " damage. " + monster.getName().get() + " has " + monster.getHP().get() + " HP left.";
        return re;
    }

    public void addBoost(String boost, int powerUp) {
        if (boost.equals("Health")) {
            getHP().increase(powerUp);
        } else if (boost.equals("Strength")) {
            getStrength().increase(powerUp);
        } else if (boost.equals("Mana")) {
            getMP().increase(powerUp);
        } else if (boost.equals("Dexterity")) {
            getDexterity().increase(powerUp);
        } else if (boost.equals("Agility")) {
            getAgility().increase(powerUp);
        } else if (boost.equals("Defense")) {
            getDefense().increase(powerUp);
        }
    }

    public String getHeader() {
        String re = String.format("%-30s %-5s %-5s %-8s %-10s %-5s %-10s %-10s %-5s %-5s %-10s", "[Type] Name", "Level", "HP", "Defense", "Strength", "MP", "Dexterity", "Agility", "Gold", "Hands", "Experience");
        return re;
    }

    public String getBody() {
        String re = String.format("%-30s %-5s %-5s %-8s %-10s %-5s %-10s %-10s %-5s %-5s %-10s", "[" + getHeroType() + "] " + getName().get(), getLevel().get(), getHP().get(), getDefense().get(), getStrength().get(), getMP().get(), getDexterity().get(), getAgility().get(), getGold().get(), getHands().get(), getExperience().get());
        return re;
    }

    public String toString() {
        String re = String.format("%-30s %-5s %-5s %-8s %-10s %-5s %-10s %-10s %-5s %-5s %-10s", "[" + getHeroType() + "] " + getName().get(), getLevel().get(), getHP().get(), getDefense().get(), getStrength().get(), getMP().get(), getDexterity().get(), getAgility().get(), getGold().get(), getHands().get(), getExperience().get());
        return re;
    }

}
