package boardgame;

public class Position {
    private int row;
    private int colmn;

    //Constructor
    public Position(int row, int colmn) {
        this.row = row;
        this.colmn = colmn;
    }

    //Get and Set
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColmn() {
        return colmn;
    }

    public void setColmn(int colmn) {
        this.colmn = colmn;
    }

    //ToString
    @Override
    public String toString() {
        return row + ", " + colmn;
    }
}
