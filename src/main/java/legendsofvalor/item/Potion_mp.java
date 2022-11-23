package item;

import character.Hero;

public class Potion_mp extends Potion{
    Potion_mp(String name, int level, int price, int sale, int powerUp){
        super(name,level,price,sale,powerUp);
        function = "MP";

    }

    @Override
    public void effect(Hero hero) {
        hero.getMP().increase(powerUp);
    }
}
