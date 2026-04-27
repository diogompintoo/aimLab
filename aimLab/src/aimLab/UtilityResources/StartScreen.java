package aimLab.UtilityResources;

import com.codeforall.simplegraphics.pictures.Picture;

public class StartScreen {

    private Picture background;

    private boolean isVisible = false;

    public void show(){

        if (isVisible) return;

        background = new Picture(0,0,"aimLab/resources/START_SCREEN.png");
        background.draw();
        isVisible = true;

    }
    public void hide(){
        if (background != null)
            background.delete();

        isVisible = false;
    }

}
