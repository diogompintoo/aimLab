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

        int x = position.getX();
        int y = position.getY();

        picture = new Picture(x, y, "aimLab/aimLab/resources/sphere.png");

        picture.draw();
        int size = grid.getCellSize();
        picture.grow(-(picture.getWidth() - size), -(picture.getHeight() - size));
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
        picture.delete();
    }
}
