package item;

import character.Hero;

public class Potion_Power extends Potion{
    Potion_Power(String name, int level, int price, int sale, int powerUp){
        super(name,level,price,sale,powerUp);
        function = "Power";

    }

    @Override
    public void effect(Hero hero) {
        hero.getStrength().increase(powerUp);
    }
}
