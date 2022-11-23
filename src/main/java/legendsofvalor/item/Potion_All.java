package item;

import character.Hero;

public class Potion_All extends Potion{
    Potion_All(String name, int level, int price, int sale, int powerUp){
        super(name,level,price,sale,powerUp);
        function = "All";

    }

    @Override
    public void effect(Hero hero) {
        hero.getAgility().increase(powerUp);
        hero.getHP().increase(powerUp);
        hero.getMP().increase(powerUp);
        hero.getDexterity().increase(powerUp);
        hero.getStrength().increase(powerUp);
        hero.getDefense().increase(powerUp);
    }
}
