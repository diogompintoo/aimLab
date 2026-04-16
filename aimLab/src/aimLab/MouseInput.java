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
        System.out.println("test click mouse");


        List<Target> targets = game.targets();
        for (int i = 0; i < targets.size(); i++) {
            Target t = targets.get(i);
            if (t.isHit(x, y)) {
                game.onTargetHit(t);
                break;
            }
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