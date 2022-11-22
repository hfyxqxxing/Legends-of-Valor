package world;

public abstract class InAccessible_Cell implements WorldCell{
    protected char symbol;
    protected String name;

    @Override
    public char getSymbol() {
        return symbol;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isAccessible() {
        return false;
    }

    @Override
    public String toString() {
        String result = "WorldCell{" +
                "symbol=" + symbol +
                ", name='" + name + '\'' +
                ", isAccessible=" + "false" + "}";
        return result;
    }
}
