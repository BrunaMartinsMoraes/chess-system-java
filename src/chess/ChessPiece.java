package chess;

import boardgame.Board;
import boardgame.Piece;

public class ChessPiece extends Piece {

    private Color color;
    private int moveCount;

    //Constructor
    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    //Get
    public Color getColor() {
        return color;
    }
}
