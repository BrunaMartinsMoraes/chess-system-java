package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    private ChessMatch chessMatch;

    //Constructor
    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    //to String
    @Override
    public String toString() {
        return "K";
    }

    //Methods
    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    private boolean testRookCastling(Position position) {
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        //above
        p.setValues(position.getRow() - 1, position.getColmn());
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColmn()] = true;
        }

        //below
        p.setValues(position.getRow() + 1, position.getColmn());
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColmn()] = true;
        }

        //left
        p.setValues(position.getRow(), position.getColmn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColmn()] = true;
        }

        //right
        p.setValues(position.getRow(), position.getColmn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColmn()] = true;
        }

        //northwest
        p.setValues(position.getRow() - 1, position.getColmn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColmn()] = true;
        }

        //northeast
        p.setValues(position.getRow() - 1, position.getColmn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColmn()] = true;
        }

        //southwest
        p.setValues(position.getRow() + 1, position.getColmn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColmn()] = true;
        }

        //southeast
        p.setValues(position.getRow() + 1, position.getColmn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColmn()] = true;
        }

        //#specialmove castling
        if (getMoveCount() == 0 && !chessMatch.getCheck()) {
            //#specialmove castling kingside rook
            Position posT1 = new Position(position.getRow(), position.getColmn() + 3);
            if (testRookCastling(posT1)) {
                Position p1 = new Position(position.getRow(), position.getColmn() + 1);
                Position p2 = new Position(position.getRow(), position.getColmn() + 2);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
                    mat[position.getRow()][position.getColmn() + 2] = true;
                }
            }
            //#specialmove castling Queenside rook
            Position posT2 = new Position(position.getRow(), position.getColmn() - 4);
            if (testRookCastling(posT2)) {
                Position p1 = new Position(position.getRow(), position.getColmn() - 1);
                Position p2 = new Position(position.getRow(), position.getColmn() - 2);
                Position p3 = new Position(position.getRow(), position.getColmn() - 3);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
                    mat[position.getRow()][position.getColmn() - 2] = true;
                }
            }
        }

        return mat;
    }
}
