package aimLab;

import com.codeforall.simplegraphics.graphics.Color;

public class Target {

    private Position position;
    private Grid grid;
    int life;
    int value;


    public Target(Position position, Grid grid) {
        this.position = position;
        this.grid = grid;
        getPosition().getRectangle().setColor(Color.RED);
    }

    public Position getPosition() {
        return position;
    }
}
