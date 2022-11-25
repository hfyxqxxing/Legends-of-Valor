/*
 * Simple wrapper class for int attributes that should be non-negative.
 * Use this wrapper to reduce the duplication of code.
 */
package legendsofvalor.character;

public class SimpleNonNegativeIntAttribute extends CharacterAttribute {
    int value;

    SimpleNonNegativeIntAttribute() {
        this.value = 0;
    }

    SimpleNonNegativeIntAttribute(int value) {
        if (value > 0) {
            this.value = value;
        } else {
            this.value = 0;
        }
    }

    public void set(int value) {
        if (value < 0) {
            return;
        }
        this.value = value;
    }

    public int get() {
        return this.value;
    }

    public void increase(int inc) {
        if (inc < 0) {
            return;
        }
        this.set(this.get() + inc);
    }

    public void decrease(int dec) {
        if (dec < 0) {
            return;
        }
        int newValue = this.get() - dec;
        if (newValue < 0) {
            newValue = 0;
        }
        this.set(newValue);
    }
}
