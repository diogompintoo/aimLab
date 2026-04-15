package aimLab;

import com.codeforall.simplegraphics.mouse.Mouse;
import com.codeforall.simplegraphics.mouse.MouseEvent;
import com.codeforall.simplegraphics.mouse.MouseHandler;
import com.codeforall.simplegraphics.mouse.MouseEventType;


public class MouseInput implements MouseHandler {

    private Score score;
    private Game game;

    public MouseInput(Game game) {
        this.game = game;
    }

    public void setScore(Score score) {
        this.score = score;
    }


    public void init() {
        Mouse mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (!game.isRunning()) return;

        int x = (int) e.getX();
        int y = (int) e.getY();

        Target t = game.getCurrentTarget();

        if (t != null && t.isHit(x, y)) {
            game.onTargetHit(t);
            System.out.println("debug click mouse");

        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

}
