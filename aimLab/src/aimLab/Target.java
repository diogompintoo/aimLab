package aimLab;

import com.codeforall.simplegraphics.graphics.Color;
import com.codeforall.simplegraphics.pictures.Picture;

public class Target implements Destroyable {

    private Position position;
    private Grid grid;
    private Picture picture;
    int life;
    int value;


    public Target(Position position, Grid grid) {
        this.position = position;
        this.grid = grid;
        int size = 150;// change this to change pgn size

        picture = new Picture(position.getX(), position.getY(), "aimLab/aimLab/resources/sphere.png");

        int deltaX = size - picture.getWidth();
        int deltaY = size - picture.getHeight();
        picture.grow(deltaX, deltaY);

        picture.translate(-picture.getWidth() / 2, -picture.getHeight() / 2);

        picture.draw();
    }

    public Position getPosition() {
        return position;
    }

    public boolean isHit(int mouseX, int mouseY){
        return  mouseX >= picture.getX() &&
                mouseX <= picture.getMaxX() &&
                mouseY >= picture.getY() &&
                mouseY <= picture.getMaxY();


    }

    public void Destroy(){
        if (picture != null){
        picture.delete();
        picture = null;
    }
}
}
