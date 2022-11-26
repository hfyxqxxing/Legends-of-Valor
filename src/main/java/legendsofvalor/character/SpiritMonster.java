/*
 * Paladin is a type of monster.
 */
package legendsofvalor.character;

public class SpiritMonster extends Monster {
    public SpiritMonster(Name name, HP hp, Level level, Damage damage, Defense defense, Agility agility) {
        super(name, hp, level, damage, defense, agility, "Spirit");
    }

    public SpiritMonster(String name, int hp, int level, int damage, int defense, int agility) {
        super(name, hp, level, damage, defense, agility, "Spirit");
    }

}
