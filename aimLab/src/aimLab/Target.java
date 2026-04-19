package aimLab;

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
        int size = 160;// change this to change pgn size

        picture = new Picture(position.getX(), position.getY(), "aimLab/resources/sphere.png");


        int deltaX = size - picture.getWidth();
        int deltaY = size - picture.getHeight();
        picture.grow(deltaX, deltaY);

        picture.translate((double) -picture.getWidth() / 2, (double) -picture.getHeight() / 2);

        targetInside();

        picture.draw();

    }

    private void targetInside(){
        int padding = 2;
        if (picture.getX() < Grid.PADDING + padding) {
            picture.translate(Grid.PADDING + padding - picture.getX(), 0);
        }
        if (picture.getMaxX() > Grid.PADDING + grid.getCols() * grid.getCellSize() - padding) {
            picture.translate(
                    Grid.PADDING + grid.getCols() * grid.getCellSize() - padding - picture.getMaxX(),
                    0);
        }
        if (picture.getY() < Grid.PADDING + padding) {
            picture.translate(0, Grid.PADDING + padding - picture.getY());
        }
        if (picture.getMaxY() > Grid.PADDING + grid.getRows() * grid.getCellSize() - padding) {
            picture.translate(0,
                    Grid.PADDING + grid.getRows() * grid.getCellSize() - padding - picture.getMaxY());
        }
    }


    public Picture getPicture(){
        return picture;

    }

    public Position getPosition() {
        return position;
    }

    public boolean isHit(double mouseX, double mouseY){
        int offsetY = 50;

        return  mouseX >= picture.getX() &&
                mouseX <= picture.getMaxX() &&
                mouseY >= picture.getY() + offsetY &&
                mouseY <= picture.getMaxY() + offsetY;


    }

    public void Destroy(){
        if (picture != null){
        picture.delete();
        picture = null;
    }
}
}
