package aimLab;

import javax.swing.SwingUtilities;

public class DisappearTimer {

    private int intervalMs;
    private int fireCount;
    private GameMode gameMode;
    private Thread thread;
    private boolean running = false;

    public DisappearTimer(int intervalMs, int fireCount) {
        this.intervalMs = intervalMs;
        this.fireCount = fireCount;
    }

    public void start(GameMode gameMode) {
        if (fireCount <= 0) return;
        this.gameMode = gameMode;
        running = true;
        thread = new Thread(new TimerTask());
        thread.setDaemon(true);
        thread.start();
    }

    public void stop() {
        running = false;
        if (thread != null) {
            thread.interrupt();
        }
    }

    private class TimerTask implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(intervalMs);
            } catch (InterruptedException e) {
                return;
            }
            if (running) {
                fireCount--;
                SwingUtilities.invokeLater(new ResetTask());
            }
        }
    }

    private class ResetTask implements Runnable {
        @Override
        public void run() {
            for (Target t : gameMode.getTargets()) {
                t.Destroy();
            }
            gameMode.getTargets().clear();
            gameMode.spawnTargets(gameMode.getTargetCount());
        }
    }
}
