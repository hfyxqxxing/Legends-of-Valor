package item;

import character.Hero;

public class Potion_Dexterity extends Potion{
    Potion_Dexterity(String name, int level, int price, int sale, int powerUp){
        super(name,level,price,sale,powerUp);
        function = "Agility";

    }

    @Override
    public void effect(Hero hero) {
        hero.getDexterity().increase(powerUp);
    }
}
