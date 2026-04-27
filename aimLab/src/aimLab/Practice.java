package aimLab;

public class Practice extends GameMode {

    public Practice(Grid grid) {
        super(grid);
    }

    @Override
    public void start() {
        super.start();
        System.out.println("Classic Mode Start");
    }
}
