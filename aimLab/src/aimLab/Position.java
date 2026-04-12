package aimLab;

import com.codeforall.simplegraphics.graphics.Color;
import com.codeforall.simplegraphics.graphics.Rectangle;

public class Position {
    private int col;
    private int row;
    private Grid grid;
    private Rectangle rectangle;


    public Position(Grid grid) {
        this.grid = grid;

        col = (int)(Math.random() * grid.getCols());
        row = (int)(Math.random() * grid.getRows());

        int x = grid.colToX(col);
        int y = grid.rowToY(row);

        rectangle = new Rectangle(x, y, grid.getCellSize(), grid.getCellSize());
        rectangle.fill();
        rectangle.setColor(Color.RED);
    }

    public int getCol() {return col;}

    public int getRow() {return row;}

    public Rectangle getRectangle() {return rectangle;}
}
