/*
 * class of HP values and increase/decrease them
 * no upper bound for HP
 * but if HP is decreased to negative, it will be set to zero
 */
package legendsofvalor.character;

public class MP extends SimpleNonNegativeIntAttribute {
    public MP() {
        super();
    }

    public MP(int value) {
        super(value);
    }

}
