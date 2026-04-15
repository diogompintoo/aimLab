package aimLab;

public class ClassicMode extends GameMode{

    public ClassicMode(Grid grid) {
        super(grid);
    }

    @Override
    public void start() {
        super.start();
        System.out.println("Classic Mode Start");
    }
}
