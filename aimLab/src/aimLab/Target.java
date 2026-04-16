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

    public boolean isHit(int mouseX, int mouseY){
        int x = position.getX();
        int y = position.getY();
        int size = grid.getCellSize();



        return mouseX >= x && mouseX <= x + size &&
                mouseY >= y && mouseY <= y + size;
    }

    public void Destroy(){
        position.getCircle().delete();
    }
}
