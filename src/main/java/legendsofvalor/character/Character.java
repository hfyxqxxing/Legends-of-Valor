/*
 * This is the base class for both hero and monster.
 */

package legendsofvalor.character;

import legendsofvalor.world.Position;


public abstract class Character {
    private Name name;
    private HP hp;
    private Level level;
    private Defense defense;
    private Position position;

    public Character(Name name, HP hp, Level level, Defense defense) {
        this.name = name;
        this.hp = hp;
        this.level = level;
        this.defense = defense;
    }

    public Character(String name, int hp, int level, int defense) {
        this.name = new Name(name);
        this.hp = new HP(hp);
        this.level = new Level(level);
        this.defense = new Defense(defense);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public HP getHP() {
        return hp;
    }

    public void setHP(HP hp) {
        this.hp = hp;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Defense getDefense() {
        return defense;
    }

    public void setDefense(Defense defense) {
        this.defense = defense;
    }

    // the header for character printout
    public abstract String getHeader();
    public abstract String getHeaderAll();

    // the body for character printout
    public abstract String getBody();
    public abstract String getBodyAll();

}
