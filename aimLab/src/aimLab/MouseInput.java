package aimLab;

import com.codeforall.simplegraphics.graphics.Canvas;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class MouseInput implements MouseListener {

    private List<Target> targets;
    private Score score;
    private Game game;

    public MouseInput(Game game) {
        this.game = game;
    }

    public void setTargets(List<Target> targets) {
        this.targets = targets;
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

        for (int i = 0; i < targets.size(); i++) {

            Target t = targets.get(i);

            if (t.isHit(x, y)) {
                game.onTargetHit(t);
                break;
            }
        }
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
