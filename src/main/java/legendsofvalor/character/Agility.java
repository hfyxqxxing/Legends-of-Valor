/*
 * Agility is the ability to dodge the attack
 * a double value between 0 and 1
 */
package legendsofvalor.character;

import java.util.concurrent.ThreadLocalRandom;

public class Agility extends SimpleNonNegativeIntAttribute {
    public Agility(int value) {
        super(value);
    }

    public Agility() {
        super();
    }

    public boolean isDodge() {
        double random = ThreadLocalRandom.current().nextDouble(0, 1);
        return random < 0.0002 * get();
    }

    public void levelUp() {
        increase((int) (get() * 0.05));
    }
}
