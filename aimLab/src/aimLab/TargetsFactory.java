package aimLab;

public class TargetsFactory {
    private Grid grid;

    public TargetsFactory(Grid grid){
        this.grid = grid;
    }
    public Target createTarget() {
        Position pos = new Position(grid);
        return new Target(pos, grid);
    }
}
