package Chess.Game.Pieces;

public class Bishop extends ChessPiece{
    public Bishop(int x, int y, boolean isWhite) {
        super(x, y);
        setName("Bishop");
        setWhite(isWhite);
    }

    @Override
    public boolean canMove(int x, int y, ChessPiece[][] board) {
        int size= board.length;
        //diagonal movement
        for(int i=0;i<size;i++){
            int top=this.getY()-i;
            int right=this.getX()+i;
            int bottom=this.getY()+i;
            int left=this.getX()-i;
            //top right
            if((x==right && right<size) && (y==top && top>0)) return true;
            //bottom left
            if((x==left && left>0) && (y==bottom && bottom<size)) return true;
            //top left
            if((x==left && left>0) && (y==top && top>0)) return true;
            //bottom right
            if((x==right && right<size) && (y==bottom && bottom<size)) return true;
        }
        return false;
    }
}
