package aimLab;

import com.codeforall.simplegraphics.graphics.Color;
import com.codeforall.simplegraphics.pictures.Picture;

public class Target {

    private Position position;
    private Grid grid;
    Picture picture;
    int life;
    int value;


    public Target(Position position, Grid grid, Picture picture) {
        this.position = position;
        this.grid = grid;
        this.picture = new Picture(0.2,0.2,"aimLab/resources/sphere.png");
        getPosition().getRectangle().setColor(Color.RED);
        picture.draw();

    }

    public int getTop(){
        return picture.getY();
    }

    public int getLeft(){
        return picture.getX();
    }

    public int getBottom(){
        return picture.getMaxY();
    }

    public int getRight(){
        return picture.getMaxX();
    }


    public Position getPosition() {
        return position;
    }
}
