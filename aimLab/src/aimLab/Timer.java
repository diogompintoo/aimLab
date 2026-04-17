package aimLab;

import com.codeforall.simplegraphics.graphics.Color;
import com.codeforall.simplegraphics.graphics.Text;

public class Timer {
    private int timeLeft;
    private Text timeText;
    private Thread timerThread;
    private boolean running = false;
    private Game game;

    public Timer(Game game, int startTime){
        this.game = game;
        this.timeLeft = startTime;
    }
    public void start() {
        if (running) return;

        timeText = new Text(600, 30, "TIME: " + timeLeft);
        timeText.setColor(Color.BLACK);
        timeText.grow(8, 8);
        timeText.draw();

        running = true;

        timerThread = new Thread(() -> {
            while (timeLeft > 0 && running) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
                timeLeft--;
                updateDisplay();
                if (timeLeft <= 10) {
                    timeText.setColor(Color.RED);
                }
            }
            if (running) {
                game.gameOver();
            }
        });
        timerThread.start();
    }
    private void updateDisplay() {
        if (timeText != null) {
            timeText.setText("TIME: " + timeLeft);
        }
    }
    public void stop() {
        running = false;
        if (timeText != null){
            timeText.delete();
        }
    }

    public int getTimeText() {
        return timeLeft;
    }
}