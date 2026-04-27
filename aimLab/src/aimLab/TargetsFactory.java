package aimLab;
import com.codeforall.simplegraphics.pictures.Picture;

import java.util.ArrayList;
import java.util.List;

public class TargetsFactory {
    private Grid grid;


    public void draw() {
        Picture picture = new Picture();
        picture.draw();

    }

    public TargetsFactory(Grid grid) {
        this.grid = grid;
    }

    public Target createTarget(List<Target> existingTargets) {
        Target newTarget;
        boolean valid;

        do {
            Position pos = new Position(grid);
            newTarget = new Target(pos, grid);

            valid = true;

            for (Target t : existingTargets) {
                if (newTarget.overlaps(t)) {
                    valid = false;
                    break;
                }
            }

        } while (!valid);

        newTarget.draw();

        return newTarget;
    }

    public List<Target> createTargets(int amount) {
        List<Target> targets = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            targets.add(createTarget(targets));
        }

        return targets;
    }

}