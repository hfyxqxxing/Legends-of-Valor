/*
 * Defense is an non-negative integer value that represents the amount of damage that can decrase.
 */
package legendsofvalor.character;

public class Defense extends SimpleNonNegativeIntAttribute {

    public Defense() {
        super();
    }

    public Defense(int defense) {
        super(defense);
    }

    public void levelUp() {
        increase((int) (get() * 0.05));
    }

}
