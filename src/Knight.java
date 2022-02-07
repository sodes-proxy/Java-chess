public class Knight extends ChessPiece{
    @Override
    public boolean canMove(int x, int y, ChessPiece[][] board) {
        if((x==this.getX()+1 ) && y==this.getY()-2) return true;
        if(x==this.getX()+2 && y==this.getY()-1) return true;
        if(x==this.getX()-1 && y==this.getY()-2) return true;
        if(x==this.getX()-2 && y==this.getY()-1) return true;
        if(x==this.getX()+1 && y==this.getY()+2) return true;
        if(x==this.getX()+2 && y==this.getY()+1) return true;
        if(x==this.getX()-1 && y==this.getY()+2) return true;
        if(x==this.getX()-2 && y==this.getY()+1) return true;
        return false;
    }

    public Knight(int x, int y, boolean isWhite) {
        super(x, y);
        this.name="Horse";
        this.isWhite=isWhite;
    }
}
