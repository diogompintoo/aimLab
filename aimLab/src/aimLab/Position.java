package aimLab;

public class Position {
    private int col;
    private int row;
    private Grid grid;
    private int x;
    private int y;


    public Position(Grid grid) {
        this.grid = grid;

        int margin = 3;

        col =margin + (int)(Math.random() * (grid.getCols() - margin * 2));
        row =margin + (int)(Math.random() * (grid.getRows() - margin * 2));

        x = grid.colToX(col) + grid.getCellSize() / 2;
        y = grid.rowToY(row) + grid.getCellSize() / 2;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCol() {return col;}

    public int getRow() {return row;}

}
