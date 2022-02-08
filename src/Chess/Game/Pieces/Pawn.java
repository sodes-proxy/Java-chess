package Chess.Game.Pieces;

public class Pawn extends ChessPiece{
    private boolean firstMove;
    public Pawn(int x, int y, boolean isWhite) {
        super(x, y);
        setName("Pawn");
        setWhite(isWhite);
        this.firstMove=true;
    }
    /**
     * TODO: Implement first move can be 2 spaces and attacking pieces
     * */
    @Override
    public boolean canMove(int x, int y,ChessPiece[][] board) {
        if(this.firstMove){
            this.firstMove=false;
            // White Pawns
            if(x==(this.getX()-2) && y==(this.getY()) && isWhite()) return true;
            if(x==(this.getX()-1) && y==(this.getY()) && isWhite()) return true;
            // Black Pawns
            if(x==(this.getX()+1) && y==(this.getY()) && !isWhite()) return true;
            if(x==(this.getX()+2) && y==(this.getY()) && !isWhite()) return true;
            else return false;
        }
        else{
            // White Pawns
            if(x==(this.getX()-1) && y==(this.getY()) && isWhite()) return true;
            // Black Pawns
            if(x==(this.getX()+1) && y==(this.getY()) && !isWhite()) return true;
            else return false;
        }
    }
}
