package aimLab;

import com.codeforall.simplegraphics.graphics.Canvas;
import com.codeforall.simplegraphics.mouse.Mouse;
import com.codeforall.simplegraphics.mouse.MouseEvent;
import com.codeforall.simplegraphics.mouse.MouseEventType;
import com.codeforall.simplegraphics.mouse.MouseHandler;
import com.codeforall.simplegraphics.pictures.Picture;

import java.util.List;

public class MouseInput implements MouseHandler {

    private Mouse mouse;
    private Game game;
    private Picture picture;
    public MouseInput(Game game) {
        this.game = game;
    }

    public void init() {
        mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
        picture = new Picture();
        //Canvas.getCanvas().addMouseListener(this);
    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        if (!game.isRunning()) return;

        double x = mouseEvent.getX();
        double y = mouseEvent.getY();

        List<Target> targets = game.targets();

        Target hitTarget = null;

        for (Target t : targets) {
            if (t.isHit(x, y)) {
                hitTarget = t;
                break;
            }
        }
        if (hitTarget != null) {
            game.onTargetHit(hitTarget);
        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }


}