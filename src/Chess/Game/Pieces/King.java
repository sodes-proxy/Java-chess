package Chess.Game.Pieces;

public class King extends ChessPiece{

    public King(int x, int y, boolean isWhite) {
        super(x, y);
        setName("King");
        setWhite(isWhite);
    }
    /**
     * TODO: add castling and restrict "dangerous" moves
     * */
    @Override
    public boolean canMove(int x, int y,ChessPiece[][] board) {
        // correct possible movements
        if(x==(this.getX()+1) && y==this.getY()) return true;
        else if(x==(this.getX()-1) && y==this.getY()) return true;
        else if(x==(this.getX()) && y==this.getY()+1) return true;
        else if(x==(this.getX()) && y==this.getY()-1) return true;
        else if(x==(this.getX()+1) && y==this.getY()+1) return true;
        else if(x==(this.getX()-1) && y==this.getY()-1) return true;
        else if(x==(this.getX()+1) && y==this.getY()-1) return true;
        else if(x==(this.getX()-1) && y==this.getY()+1) return true;
        else return false;
    }
}