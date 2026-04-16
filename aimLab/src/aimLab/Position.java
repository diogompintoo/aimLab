package aimLab;

import com.codeforall.simplegraphics.graphics.Color;
import com.codeforall.simplegraphics.graphics.Ellipse;
import com.codeforall.simplegraphics.graphics.Rectangle;

public class Position {
    private int col;
    private int row;
    private Grid grid;
    private Ellipse circle;


    public Position(Grid grid) {
        this.grid = grid;

        col = (int)(Math.random() * (grid.getCols()-2))+1;
        row = (int)(Math.random() * (grid.getRows()-2))+1;

        int x = grid.colToX(col);
        int y = grid.rowToY(row);


        circle = new Ellipse(x, y, grid.getCellSize(), grid.getCellSize());
        circle.setColor(Color.RED);
        circle.fill();
    }

    public int getCol() {return col;}

    public int getRow() {return row;}

    public Ellipse getCircle() {
        return circle;
    }
}
