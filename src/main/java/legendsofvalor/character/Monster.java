/*
 * This is the base class of any type of monster
 */
package legendsofvalor.character;

public class Monster extends Character {
    private Damage damage;
    private Agility agility;
    private String monsterType;

    public Monster(Name name, HP hp, Level level, Damage damage, Defense defense, Agility agility, String monsterType) {
        super(name, hp, level, defense);
        this.damage = damage;
        this.agility = agility;
        this.monsterType = monsterType;
    }

    public Monster(String name, int hp, int level, int damage, int defense, int agility, String monsterType) {
        super(name, hp, level, defense);
        this.damage = new Damage(damage);
        this.agility = new Agility(agility);
        this.monsterType = monsterType;
    }

    public Damage getDamage() {
        return damage;
    }

    public void setDamage(Damage damage) {
        this.damage = damage;
    }

    public Agility getAgility() {
        return agility;
    }

    public void setAgility(Agility agility) {
        this.agility = agility;
    }

    public String getMonsterType() {
        return monsterType;
    }

    public void setMonsterType(String monsterType) {
        this.monsterType = monsterType;
    }

    public String attack(Hero hero) {
        if (hero.getAgility().isDodge()) {
            return this.getName().get() + " attack hero" + hero.getName().get() + ", but " + hero.getName().get() + " dodged the attack!";
        }
        int getAttackDamage = this.getDamage().get() - hero.getDefense().get();
        if (hero.getArmor() != null) {
            getAttackDamage -= hero.getArmor().getDefense();
        }
        if (getAttackDamage < 0) {
            getAttackDamage = 0;
        }
        hero.getHP().decrease(getAttackDamage);
        String re = this.getName().get() + " attacked " + hero.getName().get() + ", damaged by " + getAttackDamage + ". " + hero.getName().get() + " HP: " + hero.getHP().get() + ". ";
        return re;
    }

    public String getHeader() {
        String re = String.format("%-25s %-10s %-10s %-10s %-10s %-10s", "[Type] Name", "Level", "HP", "Damage", "Defense", "Agility");
        return re;
    }

    public String getBody() {
        String re = String.format("%-25s %-10s %-10s %-10s %-10s %-10s", "[" + getMonsterType() + "] " + getName().get(), getLevel().get(), getHP().get(), getDamage().get(), getDefense().get(), getAgility().get());
        return re;
    }

    public String toString() {
        String re = String.format("%-25s %-10s %-10s %-10s %-10s %-10s", "[" + getMonsterType() + "] " + getName().get(), getLevel().get(), getHP().get(), getDamage().get(), getDefense().get(), getAgility().get());
        return re;
    }
}
