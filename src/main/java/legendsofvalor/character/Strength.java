/*
 * This is the class to handle strength information.
 */
package legendsofvalor.character;

public class Strength extends SimpleNonNegativeIntAttribute {
    public Strength(int value) {
        super(value);
    }

    public Strength() {
        super();
    }

    public void levelUp() {
        increase((int) (get() * 0.05));
    }
}
