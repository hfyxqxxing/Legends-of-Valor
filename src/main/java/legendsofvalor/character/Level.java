/*
 * class to store the level information of the character.
 * Levels start from 1.
 */
package legendsofvalor.character;

public class Level extends SimpleNonNegativeIntAttribute {

    public Level() {
    }

    public Level(int level) {
        super(level);
    }

    public void increase() {
        this.increase(1);
    }
}
