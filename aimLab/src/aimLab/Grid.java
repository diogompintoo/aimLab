package aimLab;

import com.codeforall.simplegraphics.graphics.Rectangle;

public class Grid {

    public static final int PADDING = 10;
    private int cellSize = 15;
    private int cols;
    private int rows;

    public Grid(int cols, int rows){
        this.cols = cols;
        this.rows = rows;
    }

    public void init(){
        Rectangle field = new Rectangle(PADDING, PADDING, cols * cellSize, rows * cellSize);
        field.draw();
    }

    public int getCellSize() {return cellSize;}

    public int getCols() {return cols;}

    public int getRows() {return rows;}

    public int rowToY(int row){return PADDING + cellSize * row;}

    public int colToX(int column){return PADDING + cellSize * column;}

}
