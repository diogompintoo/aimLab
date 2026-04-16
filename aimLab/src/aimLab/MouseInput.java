package aimLab;

import com.codeforall.simplegraphics.graphics.Canvas;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class MouseInput implements MouseListener {

    private Game game;

    public MouseInput(Game game) {
        this.game = game;
    }

    public void init() {
        Canvas.getCanvas().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (!game.isRunning()) return;

        int x = e.getX();
        int y = e.getY();


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
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}
}