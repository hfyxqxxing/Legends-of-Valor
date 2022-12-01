/*
 * Name class to store the name of the character.
 */

package legendsofvalor.character;

public class Name extends CharacterAttribute {
    String name;

    public Name(String name) {
        this.name = name;
    }

    public String get() {
        return name;
    }

    public void set(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
