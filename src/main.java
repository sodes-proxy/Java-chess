import java.util.ArrayList;
import java.util.List;
public class main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    private static final int BOARDSIZE=8;
    public static void main(String[] args){
        char[][] board=start();
        //lsit of all the pieces created
        List<ChessPiece> allPieces= new ArrayList<ChessPiece>();
        //create the chess pieces
        allPieces=createPieces(allPieces); /**check how to do this better**/
        //chessboard that will "contain all the pieces in their position"
        ChessPiece [][] piecesBoard = new ChessPiece[BOARDSIZE][BOARDSIZE];
        //put pieces
        board=putPieces(allPieces,piecesBoard,board);
        //print board
        printBoard(board);
    }

    /**
     * @return
     */
    private static char[][] start(){
        char[][]board=new char[BOARDSIZE][BOARDSIZE];
        for (int i=0;i< board.length;i++){
            for(int j=0;j< board[0].length;j++){
                board[i][j]=' ';
            }
        }
        return board;
    }
    /**
     * @param allPieces
     * @return
     */
    private static List<ChessPiece> createPieces(List<ChessPiece> allPieces){
        /**
         * Check if there is a better way to do this
         * **/
        /**White Pieces**/
        //king
        ChessPiece wKing= new King(7,4,true);
        allPieces.add(wKing);
        //pawns
        ChessPiece wPawn;
        for (int i=0;i<BOARDSIZE;i++){
            wPawn = new Pawn(6,i,true);
            allPieces.add(wPawn);
        }
        //rooks
        ChessPiece wRook= new Rook(7,0,true);
        allPieces.add(wRook);
        wRook= new Rook(7,7,true);
        allPieces.add(wRook);
        //knights
        ChessPiece wKnight= new Knight(7,1,true);
        allPieces.add(wKnight);
        wKnight= new Knight(7,6,true);
        allPieces.add(wKnight);
        //Bishops
        ChessPiece wBishop= new Bishop(7,2,true);
        allPieces.add(wBishop);
        wBishop= new Bishop(7,5,true);
        allPieces.add(wBishop);
        //Queen
        ChessPiece wQueen= new Queen(7,3,true);
        allPieces.add(wQueen);
        /**black Pieces**/
        //king
        ChessPiece bKing= new King(0,4,false);
        allPieces.add(bKing);
        //pawns
        ChessPiece bPawn;
        for (int i=0;i<BOARDSIZE;i++){
            bPawn = new Pawn(1,i,false);
            allPieces.add(bPawn);
        }
        //rooks
        ChessPiece bRook= new Rook(0,0,false);
        allPieces.add(bRook);
        bRook= new Rook(0,7,false);
        allPieces.add(bRook);
        //knights
        ChessPiece bKnight= new Knight(0,1,false);
        allPieces.add(bKnight);
        bKnight= new Knight(0,6,false);
        allPieces.add(bKnight);
        //Bishops
        ChessPiece bBishop= new Bishop(0,2,false);
        allPieces.add(bBishop);
        bBishop= new Bishop(0,5,false);
        allPieces.add(bBishop);
        //Queen
        ChessPiece bQueen= new Queen(0,3,false);
        allPieces.add(bQueen);
        return allPieces;
    }
    /**
     * @param allPieces
     * @param piecesBoard
     * @param board
     * @return
     */
    private static char[][] putPieces(List<ChessPiece> allPieces, ChessPiece[][] piecesBoard, char[][] board){
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
        return board;
    }
    /**
     * @param board
     */
    private static void printBoard(char [][] board){
        for (int i=0;i< board.length;i++){
            for(int j=0;j< board[0].length;j++){
                if((i+j)%2==0){
                    System.out.print(ANSI_WHITE_BACKGROUND+"  "+board[i][j]+ANSI_RESET);
                    System.out.print(ANSI_WHITE_BACKGROUND+ "\t"+ ANSI_RESET);
                }
                else{
                    System.out.print(ANSI_BLACK_BACKGROUND+"  "+board[i][j]+ANSI_RESET);
                    System.out.print(ANSI_BLACK_BACKGROUND+ "\t"+ ANSI_RESET);
                }
            }
            System.out.print("\n");
        }
    }
}
