package boardgame;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    //Constructor
    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.pieces = new Piece[rows][columns];
    }

    //Get and Set
    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    //Methods
    public Piece piece(int row, int column) {
        return pieces[row][column];
    }

    public Piece piece(Position position) {
        return pieces[position.getRow()][position.getColmn()];
    }

    public void placePiece(Piece piece, Position position) {
        pieces[position.getRow()][position.getColmn()] = piece;
        piece.position = position;
    }
}