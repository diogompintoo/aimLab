package aimLab;

import com.codeforall.simplegraphics.mouse.Mouse;
import com.codeforall.simplegraphics.mouse.MouseEvent;
import com.codeforall.simplegraphics.mouse.MouseEventType;
import com.codeforall.simplegraphics.mouse.MouseHandler;

public class MouseInput implements MouseHandler {

    private Mouse mouse;
    private Target target;


    public void init(){
        mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        if (mouseEvent.getY() >= target.getTop() &&
            mouseEvent.getY() <= target.getBottom() &&
            mouseEvent.getX() >= target.getLeft() &&
            mouseEvent.getX() <= target.getRight())
        {
            //add destroy target logic? call target and destroyable interface?
            System.out.println("target clicked");
        }

        else {

            System.out.println("clicking outside target");

        }

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    public void setTarget(Target target) {this.target = target;}

}
