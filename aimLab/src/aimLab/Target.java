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
        int size = 160;

        picture = new Picture(position.getX(), position.getY(), "resources/sphere.png");


        int deltaX = size - picture.getWidth();
        int deltaY = size - picture.getHeight();
        picture.grow(deltaX, deltaY);

        picture.translate((double) -picture.getWidth() / 2, (double) -picture.getHeight() / 2);

        targetInside();

        picture.draw();

    }

    private void targetInside(){
        int padding = 1;
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
        int offsetY = 32;
        int padding = 10;

        return  mouseX >= picture.getX() + padding &&
                mouseX <= picture.getMaxX() -  padding &&
                mouseY >= picture.getY() + offsetY + padding &&
                mouseY <= picture.getMaxY() + offsetY - padding;


    }

    public void Destroy(){
        if (picture != null){
        picture.delete();
        picture = null;
    }
}
}
