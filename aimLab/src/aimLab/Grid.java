package aimLab;

import com.codeforall.simplegraphics.graphics.Rectangle;
import com.codeforall.simplegraphics.pictures.Picture;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Grid {

    public static final int PADDING = 10;
    private int cellSize = 40;
    private int cols;
    private int rows;
    private Picture gridBackground;

    public Grid(int cols, int rows){
        this.cols = cols;
        this.rows = rows;
    }

    public void init(){
        //Rectangle field = new Rectangle(PADDING, PADDING, cols * cellSize, rows * cellSize);
        gridBackground = new Picture(0,0,"aimLab/resources/background.jpg");
        gridBackground.draw();
        //field.draw();

    }

    public int getCellSize() {return cellSize;}

    public int getCols() {return cols;}

    public int getRows() {return rows;}

    public int rowToY(int row){return PADDING + cellSize * row;}

    public int colToX(int column){return PADDING + cellSize * column;}

}
