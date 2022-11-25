/*
 * Paladin is a type of hero.
 * The only difference is the levelUp behavior.
 */
package legendsofvalor.character;

public class PaladinHero extends Hero {
    public PaladinHero(Name name, HP hp, Level level, Defense defense, Strength strength, MP mp, Dexterity dexterity, Agility agility, Gold gold, Hand hands, Experience experience) {
        super(name, hp, level, defense, strength, mp, dexterity, agility, gold, hands, experience, "Paladin");
    }

    public PaladinHero(String name, int hp, int level, int defense, int strength, int mp, int dexterity, int agility, int gold, int hands, int experience) {
        super(name, hp, level, defense, strength, mp, dexterity, agility, gold, hands, experience, "Paladin");
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
        getStrength().levelUp();
        getDexterity().levelUp();
    }

}
