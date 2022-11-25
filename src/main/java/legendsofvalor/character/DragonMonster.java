/*
 * DragonMonster is a kind of Monster
 */
package legendsofvalor.character;

public class DragonMonster extends Monster {
    public DragonMonster(Name name, HP hp, Level level, Damage damage, Defense defense, Agility agility) {
        super(name, hp, level, damage, defense, agility, "Dragon");
    }

    public DragonMonster(String name, int hp, int level, int damage, int defense, int agility) {
        super(name, hp, level, damage, defense, agility, "Dragon");
    }

}
