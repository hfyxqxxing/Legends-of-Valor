/*
 * This is the spaces of the world map.
 * Only Symbol will be printed in the world map.
 */

package legendsofvalor.world;

public interface WorldCell {

    char getSymbol();

    String getName();

    boolean isAccessible();

    String toString();

    boolean hasHero();

    boolean hasMonster();

}
