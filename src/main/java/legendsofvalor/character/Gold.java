/*
 * class of gold amount of the character.
 * default gold is 0.
 * gold cannot be negative.
 */
package legendsofvalor.character;

public class Gold extends SimpleNonNegativeIntAttribute {

    public Gold() {
        super();
    }

    public Gold(int gold) {
        super(gold);
    }

    public boolean isGoldEnough(int cost) {
        return this.get() >= cost;
    }

}
