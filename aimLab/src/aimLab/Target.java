package aimLab;

import com.codeforall.simplegraphics.graphics.Color;

public class Target implements Destroyable {

    private Position position;
    private Grid grid;
    int life;
    int value;


    public Target(Position position, Grid grid) {
        this.position = position;
        this.grid = grid;
        getPosition().getCircle().setColor(Color.RED);
    }

    public Position getPosition() {
        return position;
    }

    /*@Override
    public void Destroy() {
        position.getRectangle().delete();
    }*/

    public void Destroy(){
        position.getCircle().delete();
    }
}
