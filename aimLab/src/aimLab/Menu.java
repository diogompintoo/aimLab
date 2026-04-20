package aimLab;

import com.codeforall.simplegraphics.graphics.Text;
import com.codeforall.simplegraphics.graphics.Color;

public class Menu {
    private Text title;
    private Text start;
    private boolean isVisible = false;

    public void show(){

        if (isVisible) return;

        title = new Text(160 ,160, "AIMLAB");
        title.grow(30,30);
        title.setColor(Color.BLACK);
        title.draw();

        start = new Text(250 ,250, "PRESS TO START");
        start.grow(10,10);
        start.draw();

        isVisible = true;

    }
    public void hide(){
        if (title != null)
            title.delete();
        if (start != null)
            start.delete();

        isVisible = false;
    }

}
