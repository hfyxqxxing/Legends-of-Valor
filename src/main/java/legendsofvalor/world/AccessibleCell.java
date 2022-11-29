package legendsofvalor.world;

import legendsofvalor.character.Hero;
import legendsofvalor.character.Monster;

public abstract class AccessibleCell implements WorldCell {

    protected char symbol;
    protected String name;

    protected Hero hero = null;
    protected Monster monster = null;


    @Override
    public char getSymbol() {
        return symbol;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isAccessible() {
        return true;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hero getHero() {
        return hero;
    }
    public boolean hasHero(){
        if (hero == null){
            return false;
        }else {
            return true;
        }
    }


    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Monster getMonster() {
        return monster;
    }

    public boolean hasMonster(){
        if (monster == null){
            return false;
        }else {
            return true;
        }
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    @Override
    public String toString() {
        String result = "WorldCell{" + "symbol=" + symbol + ", name='" + name + '\'' + ", isAccessible=" + "true";
        if (hero == null) {
            result = result + ", present Hero is ";// + hero.getName();
        } else {
            result = result + ", There is no Hero here";
        }
        if (monster == null) {
            result = result + ", present Monster is ";// + monster.getName();
        } else {
            result = result + ", There is no Monster here";
        }

        return result;
    }
}
