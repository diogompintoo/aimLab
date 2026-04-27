package aimLab;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GameMode {
    protected Grid grid;
    protected TargetsFactory factory;
    protected List<Target> targets;
    private int targetCount;
    private DisappearTimer disappearTimer;
    private boolean disappearEnabled = false;

    public GameMode(Grid grid) {
        this.grid = grid;
        this.factory = new TargetsFactory(grid);
    }

    public void start() {
        spawnTargets(5);
    }

    public void setDisappearTimer(int intervalMs, int fireCount) {
        this.disappearTimer = new DisappearTimer(intervalMs, fireCount);
        this.disappearEnabled = true;
    }

    public void spawnTargets(int amount) {
        targetCount = amount;
        targets = new CopyOnWriteArrayList<>();
        for (int i = 0; i < amount; i++) {
            targets.add(factory.createTarget(targets));
        }
        if (disappearEnabled && disappearTimer != null) {
            disappearTimer.start(this);
        }
    }

    public void spawnNewTargets() {
        targets.add(factory.createTarget(targets));
    }

    public int getTargetCount() {
        return targetCount;
    }

    public List<Target> getTargets() {
        return targets;
    }
}
