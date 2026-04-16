package aimLab;

import com.codeforall.simplegraphics.mouse.Mouse;
import com.codeforall.simplegraphics.mouse.MouseEvent;
import com.codeforall.simplegraphics.mouse.MouseHandler;
import com.codeforall.simplegraphics.mouse.MouseEventType;

import java.util.List;

public class MouseInput implements MouseHandler {

    private Game game;
    private List<Target> targets;

    public MouseInput(Game game) {
        this.game = game;
    }

    public void setTargets(List<Target> targets) {
        this.targets = targets;
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

        for (int i = 0; i < targets.size(); i++) {
            Target t = targets.get(i);
            if (t.isHit(x, y)) {
                game.onTargetHit(t);
                break;
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {}
}