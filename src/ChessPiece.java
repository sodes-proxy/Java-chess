/**
 *
 */
public abstract class ChessPiece {
    private int x;
    private int y;
    String name;
    boolean isWhite;
    public ChessPiece(int x, int y) {
        this.x = x;
        this.y = y;
        this.isWhite = isWhite;
        this.name=name;
    }
    public boolean canMove(int x,int y){
        return false;
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

    public void setY(int y) {
        this.y = y;
    }
    public void printObj(){
        System.out.println(this.name);
        System.out.println(this.isWhite? "White" : "Black");
        System.out.println("y: " + this.x);
        System.out.println("x: "+ this.y);
    }
}
