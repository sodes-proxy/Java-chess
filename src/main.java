import Chess.Game.Pieces.*;
import Chess.Terminal.TerminalColor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    private static final int BOARDSIZE = 8;

    public static void main(String[] args) {
        /**
         * FIXME: X and Y are inverted, it generates confusion
         * */
        char[][] board = start();
        //lsit of all the pieces created
        List<ChessPiece> allPieces = new ArrayList<ChessPiece>();
        //create the chess pieces
        allPieces = createPieces(allPieces); /**check how to do this better**/
        //chessboard that will "contain all the pieces in their position"
        ChessPiece[][] piecesBoard = new ChessPiece[BOARDSIZE][BOARDSIZE];
        //put pieces
        board = putPieces(allPieces, piecesBoard, board);
        printInstructions();
        while (true) {
            //print board
            printBoard(board);
            //get position
            piecesBoard = movePiece(piecesBoard, board);
        }
    }

    private static ChessPiece[][] movePiece(ChessPiece[][] board, char[][] terminalBoard) {
        int x0 = 100;
        int y0 = 100;
        int x1 = 100;
        int y1 = 100;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter position of piece you want to move :");
        String str = sc.nextLine();
        String[] aux = str.split(" ");
        /**
         * TODO: modify validation() to make the process of reading input cleaner
         * */
        if (validation(aux)) {
            x0 = Integer.parseInt(aux[0]);
            y0 = Integer.parseInt(aux[1]);
        } else {
            return board;
        }
        if(board[y0][x0]==null){
            System.out.println("There is no piece in that position");
            return board;
        }
        System.out.println("you've selected: " + (board[y0][x0].isWhite() ? "White" : "Black") + " " + board[y0][x0].getName());
        System.out.print("Enter position you want to move to:");
        str = sc.nextLine();
        aux = str.split(" ");
        if (validation(aux)) {
            x1 = Integer.parseInt(aux[0]);
            y1 = Integer.parseInt(aux[1]);
        } else {
            return board;
        }
        if (board[y0][x0].canMove(y1, x1, board) && board[y1][x1] == null) {
            ChessPiece tmp = board[y0][x0];
            char tmpChar = terminalBoard[y0][x0];
            board[y0][x0].setX(y1);
            board[y0][x0].setY(x1);
            board[y0][x0] = null;
            terminalBoard[y0][x0] = ' ';
            board[y1][x1] = tmp;
            terminalBoard[y1][x1] = tmpChar;
        } else {
            //board[y0][x0].printObj();
            System.out.println("Illegal move");
        }
        return board;
    }

    private static boolean validation(String[] str) {
        int x;
        int y;
        //validation
        try {
            x = Integer.parseInt(str[0]);
            y = Integer.parseInt(str[1]);
        } catch (NumberFormatException e) {
            System.out.println("Please introduce numbers");
            return false;
        }
        if (x > (BOARDSIZE - 1) || y > (BOARDSIZE - 1) || x < 0 || y < 0) {
            System.out.println("please introduce a valid position");
            return false;
        }
        return true;
    }

    /**
     * @return
     */
    private static char[][] start() {
        char[][] board = new char[BOARDSIZE][BOARDSIZE];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = ' ';
            }
        }
        return board;
    }

    /**
     * @param allPieces
     * @return
     */
    private static List<ChessPiece> createPieces(List<ChessPiece> allPieces) {
        /**
         * Check if there is a better way to do this
         * **/
        /**White Pieces**/
        //king
        ChessPiece wKing = new King(7, 4, true);
        allPieces.add(wKing);
        //pawns
        ChessPiece wPawn;
        for (int i = 0; i < BOARDSIZE; i++) {
            wPawn = new Pawn(6, i, true);
            allPieces.add(wPawn);
        }
        //rooks
        ChessPiece wRook = new Rook(7, 0, true);
        allPieces.add(wRook);
        wRook = new Rook(7, 7, true);
        allPieces.add(wRook);
        //knights
        ChessPiece wKnight = new Knight(7, 1, true);
        allPieces.add(wKnight);
        wKnight = new Knight(7, 6, true);
        allPieces.add(wKnight);
        //Bishops
        ChessPiece wBishop = new Bishop(7, 2, true);
        allPieces.add(wBishop);
        wBishop = new Bishop(7, 5, true);
        allPieces.add(wBishop);
        //Chess.Game.Pieces.Queen
        ChessPiece wQueen = new Queen(7, 3, true);
        allPieces.add(wQueen);
        /**black Pieces**/
        //king
        ChessPiece bKing = new King(0, 4, false);
        allPieces.add(bKing);
        //pawns
        ChessPiece bPawn;
        for (int i = 0; i < BOARDSIZE; i++) {
            bPawn = new Pawn(1, i, false);
            allPieces.add(bPawn);
        }
        //rooks
        ChessPiece bRook = new Rook(0, 0, false);
        allPieces.add(bRook);
        bRook = new Rook(0, 7, false);
        allPieces.add(bRook);
        //knights
        ChessPiece bKnight = new Knight(0, 1, false);
        allPieces.add(bKnight);
        bKnight = new Knight(0, 6, false);
        allPieces.add(bKnight);
        //Bishops
        ChessPiece bBishop = new Bishop(0, 2, false);
        allPieces.add(bBishop);
        bBishop = new Bishop(0, 5, false);
        allPieces.add(bBishop);
        //Chess.Game.Pieces.Queen
        ChessPiece bQueen = new Queen(0, 3, false);
        allPieces.add(bQueen);
        return allPieces;
    }

    /**
     * @param allPieces
     * @param piecesBoard
     * @param board
     * @return
     */
    private static char[][] putPieces(List<ChessPiece> allPieces, ChessPiece[][] piecesBoard, char[][] board) {
        //putting the pieces in their respective place
        for (ChessPiece piece : allPieces) {
            piecesBoard[piece.getX()][piece.getY()] = piece;
        }
        //put pieces in the text board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (piecesBoard[i][j] != null) {
                    board[i][j] = piecesBoard[i][j].getName().charAt(0);
                }
            }
        }
        return board;
    }

    /**
     * @param board
     */
    private static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print(TerminalColor.ANSI_WHITE_BACKGROUND.getColor() + "  " + board[i][j] + TerminalColor.ANSI_RESET.getColor());
                    System.out.print(TerminalColor.ANSI_WHITE_BACKGROUND.getColor() + "\t" + TerminalColor.ANSI_RESET.getColor());
                } else {
                    System.out.print(TerminalColor.ANSI_BLACK_BACKGROUND.getColor() + "  " + board[i][j] + TerminalColor.ANSI_RESET.getColor());
                    System.out.print(TerminalColor.ANSI_BLACK_BACKGROUND.getColor() + "\t" + TerminalColor.ANSI_RESET.getColor());
                }
            }
            System.out.print("\n" + TerminalColor.ANSI_RESET.getColor());
        }
    }

    /**
     * TODO: add explanation of coordinates (with arrows and numbers)
     */
    private static void printInstructions() {
        System.out.println("To select a piece to move first you need to select which one you want\n" + TerminalColor.ANSI_RED.getColor() + "introduce your coordinate like the following X Y" + TerminalColor.ANSI_RESET.getColor() + " with a space between them\nAnd then you need to select the position you want to move the selected piece\nHere you can see the coordinates of each square in the board:");
        for (int i = 0; i < BOARDSIZE; i++) {
            for (int j = 0; j < BOARDSIZE; j++) {
                if (((i + j) - 1) % 2 == 0) {
                    System.out.print(""+TerminalColor.ANSI_WHITE_BACKGROUND.getColor() +i + " " + j+" " +TerminalColor.ANSI_RESET.getColor());
                    System.out.print(TerminalColor.ANSI_WHITE_BACKGROUND.getColor() + "\t" + TerminalColor.ANSI_RESET.getColor());
                } else {
                    System.out.print(""+TerminalColor.ANSI_BLACK_BACKGROUND.getColor() + i + " " + j + TerminalColor.ANSI_RESET.getColor());
                    System.out.print(""+TerminalColor.ANSI_BLACK_BACKGROUND.getColor() + "\t" + TerminalColor.ANSI_RESET.getColor());
                }
            }
            System.out.print("\n" + TerminalColor.ANSI_RESET.getColor());
        }
        System.out.println("\nHave Fun!\n");
    }
}
