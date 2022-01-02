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

    /**
     * This method returns true when position given is one where the piece can move.
     * It uses the board to determine if any piece in the way is friend or foe
     * @param x X value of new position
     * @param y Y value of new position
     * @param board gameboard with the pieces and their positions
     * @return
     */
    public boolean canMove(int x,int y,ChessPiece[][] board){
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
