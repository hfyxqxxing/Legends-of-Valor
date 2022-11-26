/*
 * Exoskeleton is a kind of Monster
 */
package legendsofvalor.character;

public class ExoskeletonMonster extends Monster {
    public ExoskeletonMonster(Name name, HP hp, Level level, Damage damage, Defense defense, Agility agility) {
        super(name, hp, level, damage, defense, agility, "Exoskeleton");
    }

    public ExoskeletonMonster(String name, int hp, int level, int damage, int defense, int agility) {
        super(name, hp, level, damage, defense, agility, "Exoskeleton");
    }

}
