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

        picture = new Picture(position.getX(), position.getY(), "aimLab/resources/sphere.png");


        int deltaX = size - picture.getWidth();
        int deltaY = size - picture.getHeight();
        picture.grow(deltaX, deltaY);

        picture.translate((double) -picture.getWidth() / 2, (double) -picture.getHeight() / 2);

        targetInside();


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

    public void draw() {
        picture.draw();
    }

    public Position getPosition() {
        return position;
    }

    public boolean isHit(double mouseX, double mouseY) {
        double centerX = picture.getX() + picture.getWidth() / 2.0;
        double centerY = picture.getY() + picture.getHeight() / 2.0 + 25;

        double a = picture.getWidth() / 2.0;
        double b = picture.getHeight() / 2.0;

        double dx = mouseX - centerX;
        double dy = mouseY - centerY;

        return (dx * dx) / (a * a) + (dy * dy) / (b * b) <= 1.0;
    }

    public boolean overlaps(Target other) {
        double dx = this.position.getX() - other.position.getX();
        double dy = this.position.getY() - other.position.getY();

        double r1 = this.picture.getWidth() / 2.0;
        double r2 = other.picture.getWidth() / 2.0;

        return dx * dx + dy * dy < (r1 + r2) * (r1 + r2);
    }

    public void Destroy(){
        if (picture != null){
            picture.delete();
            picture = null;
        }
    }
}
