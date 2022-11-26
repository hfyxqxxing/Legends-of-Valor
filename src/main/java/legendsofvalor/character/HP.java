/*
 * class of HP values and increase/decrease them
 * no upper bound for HP
 * but if HP is decreased to negative, it will be set to zero
 */
package legendsofvalor.character;

public class HP extends SimpleNonNegativeIntAttribute {
    public HP() {
        super();
    }

    public HP(int value) {
        super(value);
    }

}
