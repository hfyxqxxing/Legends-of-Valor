/*
 * Dexterity increases the amount of the damage when using a spell.
 */
package legendsofvalor.character;

public class Dexterity extends SimpleNonNegativeIntAttribute {
    public Dexterity() {
        super();
    }

    public Dexterity(int value) {
        super(value);
    }

    public void levelUp() {
        increase((int) (get() * 0.05));
    }
}
