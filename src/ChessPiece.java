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
    public void move(int x,int y, ChessPiece [][] board){
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
}
