package aimLab;

public class GameMode {
    protected Grid grid;
    protected TargetsFactory factory;
    protected Target currentTarget;

    public GameMode (Grid grid) {
        this.grid = grid;
        this.factory = new TargetsFactory(grid);
    }

    public void start(){
        spawnTarget();
    }
    public void spawnTarget() {
        currentTarget = factory.createTarget();
    }
}
