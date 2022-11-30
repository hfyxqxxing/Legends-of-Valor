package legendsofvalor.world;

public class Position {

    private int x;
    private int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Position getPosition(){
        return this;
    }

    public boolean equals(Position the_other){
        if (x==the_other.getX() && y==the_other.getY()){
            return true;
        }else {
            return false;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public Position changeto(int x, int y){
        return new Position(this.x+x,this.y+y);
    }

    public void setY(int y) {
        this.y = y;
    }
}
