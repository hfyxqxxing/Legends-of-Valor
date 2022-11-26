/*
 * Sorcerer is a type of hero.
 * The only difference is the levelUp behavior.
 */
package legendsofvalor.character;

public class SorcererHero extends Hero {
    public SorcererHero(Name name, HP hp, Level level, Defense defense, Strength strength, MP mp, Dexterity dexterity, Agility agility, Gold gold, Hand hands, Experience experience) {
        super(name, hp, level, defense, strength, mp, dexterity, agility, gold, hands, experience, "Sorcerer");
    }

    public SorcererHero(String name, int hp, int level, int defense, int strength, int mp, int dexterity, int agility, int gold, int hands, int experience) {
        super(name, hp, level, defense, strength, mp, dexterity, agility, gold, hands, experience, "Sorcerer");
    }

    protected void levelUp() {
        getLevel().increase();
        getHP().set(getLevel().get() * 100);
        getMP().set(getLevel().get() * 100);
        getAgility().levelUp();
        getDexterity().levelUp();
        getStrength().levelUp();
        getDefense().levelUp();
        // do extra level up
        getDexterity().levelUp();
        getAgility().levelUp();
    }
}
