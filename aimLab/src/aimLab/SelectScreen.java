package aimLab;

import com.codeforall.simplegraphics.pictures.Picture;

public class SelectScreen {

    private Picture background;
    private boolean isVisible = false;

    public void show() {
        if (isVisible) return;

        background = new Picture(0,0, "aimLab/resources/MODE_SELECT.png");
        background.draw();

        isVisible = true;
    }
    public void hide() {
        if (background != null)
        background.delete();

        isVisible = false;
    }
}
