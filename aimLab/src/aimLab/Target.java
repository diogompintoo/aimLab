package aimLab;

import com.codeforall.simplegraphics.graphics.Color;
import com.codeforall.simplegraphics.pictures.Picture;

import com.codeforall.simplegraphics.pictures.Picture;

public class Target {

    private Picture picture;
    private boolean alive = true;

    public Target(int x, int y) {
        picture = new Picture(x, y, "aimLab/resources/sphere.png");
        picture.draw();
    }

    public Picture getPicture() {
        return picture;
    }

    public int getX() {
        return picture.getX();
    }

    public int getY() {
        return picture.getY();
    }

    public boolean isHit(int mouseX, int mouseY) {

        if (!alive) return false;

        if (mouseX >= picture.getX() &&
                mouseX <= picture.getMaxX() &&
                mouseY >= picture.getY() &&
                mouseY <= picture.getMaxY()) {

            picture.delete();
            alive = false;
            return true;
        }

        return false;
    }

    public boolean isOverlapping(int x, int y) {

        int width = picture.getWidth(); // aprox tamaño de la esfera (ajústalo si quieres)
        int height = picture.getHeight();

        return !(x + width < picture.getX() ||
                x > picture.getMaxX() ||
                y + height < picture.getY() ||
                y > picture.getMaxY());
    }
}