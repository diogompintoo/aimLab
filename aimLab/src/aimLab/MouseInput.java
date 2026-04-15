package aimLab;

import com.codeforall.simplegraphics.graphics.Canvas;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class MouseInput implements MouseListener {

    private Score score;
    private Game game;

    public MouseInput(Game game) {
        this.game = game;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public void init() {
        Canvas.getCanvas().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (!game.isRunning()) return;

        int x = e.getX();
        int y = e.getY();

        Target t = game.getCurrentTarget();

        if (t != null && t.isHit(x, y)) {
            game.onTargetHit(t);

        }
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
