package legendsofvalor.item;

public class ArmorCreator {

    /**
     * I think we need an ItemCreator(Inheritence for these creators),
     * (Giving a name to distribute or generate from existing objects randomly)
     * but the method we input all data is not decided.
     * Read in files(Recommended) or hard-coded in files. ItemCreator() is hard to code without these
     */
    public static Armor create(String name, int level, int price, int sale, int defense) {
        return new Armor(name, level, price, sale, defense);
    }
}
