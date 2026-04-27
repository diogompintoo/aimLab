package aimLab.GameMods;
import aimLab.Grid;
import aimLab.Target;
import aimLab.TargetsFactory;

import java.util.List;

public class GameMode {
    protected Grid grid;
    protected TargetsFactory factory;
    protected List<Target> targets;

    public GameMode(Grid grid) {
        this.grid = grid;
        this.factory = new TargetsFactory(grid);
    }

    public void start() {
        spawnTargets(5);
    }

    public void spawnTargets(int amount) {
        targets = factory.createTargets(amount);
    }

    //public void spawnNewTargets() {
       // targets.add(factory.createTarget());
    }

    //public List<Target> getTargets() {
      //  return targets;
  //  }
//}