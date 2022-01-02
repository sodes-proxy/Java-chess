public class Rook extends ChessPiece{
    public Rook(int x, int y, boolean isWhite) {
        super(x, y);
        this.name="Rook";
        this.isWhite=isWhite;
    }
    @Override
    public boolean canMove(int x, int y,ChessPiece[][] board) {
        //Horizontal movement
        int size= board.length;
        for(int i=0;i<size;i++){
            int rightRange=this.getY()+i;
            int leftRange=this.getY()-i;
            if(x==(this.getX()) && y==rightRange && rightRange<size) return true;
            if(x==(this.getX()) && y==leftRange && leftRange>0) return true;
        }
        //vertical movement
        for(int i=0;i<size;i++){
            int bottomRange=this.getX()+i;
            int upperRange=this.getX()-i;
            if((x==bottomRange && bottomRange<size) && y==this.getY()) return true;
            if((x==upperRange && upperRange>0) && y==this.getY()) return true;
        }
        return false;
    }
}
