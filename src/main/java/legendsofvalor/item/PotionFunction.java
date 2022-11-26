package legendsofvalor.item;

import legendsofvalor.character.Hero;

public abstract class PotionFunction {
    protected String function;
    protected int powerUp;

    public PotionFunction(String function, int powerUp) {
        this.function = function;
        this.powerUp = powerUp;
    }

    public String getFunction() {
        return function;
    }

    public int getPowerUp() {
        return powerUp;
    }

    public abstract void effect(Hero hero);
}
