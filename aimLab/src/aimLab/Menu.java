package aimLab;

import com.codeforall.simplegraphics.graphics.Text;
import com.codeforall.simplegraphics.graphics.Color;

public class Menu {
    private Text title;
    private Text start;

    public void show(){
        title = new Text(300 ,300, "AIMLAB");
        title.grow(25,25);
        title.setColor(Color.BLACK);
        title.draw();

        start = new Text(300 ,300, "PRESS TO START");
        start.grow(15,15);
        start.draw();

    }
    public void hide(){
        if (title != null)
            title.delete();
        if (start != null)
            start.delete();
    }
        
}
