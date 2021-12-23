import java.util.ArrayList;
import java.util.List;
public class main {
    private static final int BOARDSIZE=8;
    public static void main(String[] args){
        char[][] board=start();
        //lsit of all the pieces created
        List<ChessPiece> allPieces= new ArrayList<ChessPiece>();
        //chessboard that will "contain all the pieces in their position"
        ChessPiece [][] piecesBoard = new ChessPiece[BOARDSIZE][BOARDSIZE];
        //create the chess pieces
        ChessPiece wKing= new King(7,4,true);
        ChessPiece bKing= new King(0,4,false);
        allPieces.add(wKing);
        allPieces.add(bKing);
        //putting the pieces in their respective place
        for (ChessPiece piece:allPieces) {
            piecesBoard[piece.getX()][piece.getY()]=piece;
        }
        //put pieces in the text board
        for (int i=0;i< board.length;i++){
            for(int j=0;j< board[0].length;j++){
                if(piecesBoard[i][j]!=null){
                    board[i][j]=piecesBoard[i][j].name.charAt(0);
                }
            }
        }
        //print board
        for (int i=0;i< board.length;i++){
            for(int j=0;j< board[0].length;j++){
                System.out.print(board[i][j]);
                System.out.print("\t");
            }
            System.out.print("\n");
        }
    }

    /**
     * @return
     */
    private static char[][] start(){
        char[][]board=new char[BOARDSIZE][BOARDSIZE];
        for (int i=0;i< board.length;i++){
            for(int j=0;j< board[0].length;j++){
                board[i][j]='x';
            }
        }
        return board;
    }
}
