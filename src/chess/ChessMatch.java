package chess;

import boardgame.Board;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {

//    private int turn;
//    private Color currentPlayer;
//    private boolean check;
//    private boolean checkMate;
//    private ChessPiece enPassantVulnerable;
//    private ChessPiece promoted;

    private Board board;

    //Constructor
    public ChessMatch() {
        board = new Board(8, 8);
        initialSetup();
    }

    //Methods
    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i=0; i< board.getRows(); i++) {
            for (int j=0; j< board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return mat;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }

    private void initialSetup() {
        placeNewPiece('b', 6, new Rook(board, Color.WHITE));
        placeNewPiece('e', 8, new King(board, Color.BLACK));
    }
}
