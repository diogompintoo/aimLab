package aimLab;

import com.codeforall.simplegraphics.graphics.Text;
import com.codeforall.simplegraphics.pictures.Picture;

public class StartScreen {
    private Text title;
    private Text start;
    private Picture background;

    private boolean isVisible = false;

    public void show(){

        if (isVisible) return;

        background = new Picture(0,0,"aimLab/resources/START_SCREEN.png");
        background.draw();

    }
    public void hide(){
        if (background != null)
            background.delete();

        isVisible = false;
    }

}
