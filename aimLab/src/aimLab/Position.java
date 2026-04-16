package aimLab;

import com.codeforall.simplegraphics.graphics.Color;
import com.codeforall.simplegraphics.graphics.Ellipse;
import com.codeforall.simplegraphics.graphics.Rectangle;

public class Position {
    private int col;
    private int row;
    private Grid grid;
    private Ellipse circle;
    private int x;
    private int y;


    public Position(Grid grid) {
        this.grid = grid;

        col = (int)(Math.random() * (grid.getCols()-2))+1;
        row = (int)(Math.random() * (grid.getRows()-2))+1;

        x = grid.colToX(col);
        y = grid.rowToY(row);




        circle = new Ellipse(x, y, grid.getCellSize(), grid.getCellSize());

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCol() {return col;}

    public int getRow() {return row;}

    public Ellipse getCircle() {
        return circle;
    }
}
