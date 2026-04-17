package aimLab;

public class Position {
    private int col;
    private int row;
    private Grid grid;
    private int x;
    private int y;


    public Position(Grid grid) {
        this.grid = grid;

        col = (int)(Math.random() * (grid.getCols()-2))+1;
        row = (int)(Math.random() * (grid.getRows()-2))+1;

        x = grid.colToX(col);
        y = grid.rowToY(row);



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
