package item;

import character.Hero;

public class Potion_Agility extends Potion{

    Potion_Agility(String name, int level, int price, int sale, int powerUp){
        super(name,level,price,sale,powerUp);
        function = "Agility";

    }

    @Override
    public void effect(Hero hero) {
        hero.getAgility().increase(powerUp);
    }
}
