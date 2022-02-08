package Chess.Game.Pieces;

public class Queen extends ChessPiece{
    public Queen(int x, int y, boolean isWhite) {
        super(x, y);
        setName("Queen");
        setWhite(isWhite);
    }
}
