package aimLab;
import java.util.ArrayList;
import java.util.List;

public class TargetsFactory {
    private Grid grid;

    public TargetsFactory(Grid grid) {
        this.grid = grid;
    }

    public Target createTarget() {
        Position pos = new Position(grid);
        return new Target(pos, grid);
    }

    public List<Target> createTargets(int amount) {
        List<Target> targets = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            targets.add(createTarget());
        }
        return targets;

    }
}
