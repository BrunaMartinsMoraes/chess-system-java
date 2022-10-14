package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {

    //Constructor
    public Bishop(Board board, Color color) {
        super(board, color);
    }

    //toString
    @Override
    public String toString() {
        return "B";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        //nw
        p.setValues(position.getRow() - 1, position.getColmn() - 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColmn()] = true;
            p.setValues(p.getRow() - 1, p.getColmn() - 1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColmn()] = true;
        }

        //ne
        p.setValues(position.getRow() - 1, position.getColmn() + 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColmn()] = true;
            p.setValues(p.getRow() - 1, p.getColmn() + 1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColmn()] = true;
        }

        //se
        p.setValues(position.getRow() + 1, position.getColmn() + 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColmn()] = true;
            p.setValues(p.getRow() + 1, p.getColmn() + 1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColmn()] = true;
        }

        //sw
        p.setValues(position.getRow() + 1, position.getColmn() - 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColmn()] = true;
            p.setValues(p.getRow() + 1, p.getColmn() - 1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColmn()] = true;
        }

        return mat;
    }
}
