package chess;

import boardgame.Position;

public class ChessPosition {

    private char column;
    private int row;

    //Constructor
    public ChessPosition(char column, int row) {
        if (column < 'a' || column > 'h' || row < 1 || row > 8) {
            throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8.");
        }
        this.column = column;
        this.row = row;
    }

    //Get
    public void setColumn(char column) {
        this.column = column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    //Method
    protected Position toPosition() {
        return new Position(8 - row, column - 'a');
    }

    protected static ChessPosition fromPosition(Position position) {
        return new ChessPosition((char)('a' + position.getColmn()), 8 - position.getRow());
    }

    //toString

    @Override
    public String toString() {
        return "" + column + row;
    }
}
