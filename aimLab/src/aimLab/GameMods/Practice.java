package aimLab.GameMods;

import aimLab.GameMode;
import aimLab.Grid;

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
