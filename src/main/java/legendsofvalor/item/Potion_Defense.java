package item;

import character.Hero;

public class Potion_Defense extends Potion{
    Potion_Defense(String name, int level, int price, int sale, int powerUp){
        super(name,level,price,sale,powerUp);
        function = "Defense";

    }

    @Override
    public void effect(Hero hero) {
        hero.getDefense().increase(powerUp);
    }
}
