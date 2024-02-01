package fr.emse.ai.csp.nqueen;

public class ChessBoardCell {
    public int row;
    public int column;

    public ChessBoardCell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public String toString() {
        return "(" + row + ", " + column + ")";
    }
}
