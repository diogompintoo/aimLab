package aimLab;

import java.util.ArrayList;
import java.util.List;


public class Game {

    enum GameState {
        MENU,
        PLAYING,
        GAME_OVER;
    }
    GameState currentState = GameState.MENU;

    private List<Target> targets;
    private Score score;
    private MouseInput mouse;

    private boolean running = true;

    public void start(){
        targets = new ArrayList<>();
        score = new Score();

        createTargets(10);

        mouse = new MouseInput(this);
        mouse.setTargets(targets);
        mouse.setScore(score);
        mouse.init();

        startTimer();
    }

    private void createTargets(int number) {
        for (int i = 0; i < number; i++) {
            spawnTarget();
        }
    }

    public void spawnTarget() {
        int x, y;
        boolean validPosition;
        int attempts = 0;

        int size = 64; // tamaño aproximado de la esfera

        do {
            x = (int)(Math.random() * 600);
            y = (int)(Math.random() * 400);

            validPosition = true;

            for (Target t : targets) {

                if (isOverlapping(
                        x, y, size,
                        t.getX(), t.getY(), size
                )) {
                    validPosition = false;
                    break;
                }
            }

            attempts++;

        } while (!validPosition && attempts < 100);

        targets.add(new Target(x, y));
    }

    public void onTargetHit(Target target) {
        score.add();
        targets.remove(target);

        if (running) {
            spawnTarget();
        }
    }

    private void startTimer() {

        new Thread(() -> {
            try {
                Thread.sleep(30000); // 30s
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            running = false;
            System.out.println("GAME OVER");
            System.out.println("Final Score: " + score.getScore());

        }).start();
    }


    private boolean isOverlapping(int x1, int y1, int size1,
                                  int x2, int y2, int size2) {

        return !(x1 + size1 < x2 ||
                x1 > x2 + size2 ||
                y1 + size1 < y2 ||
                y1 > y2 + size2);
    }

    public boolean isRunning() {
        return running;
    }

    public void run(){
        while (true){
            if (currentState == GameState.MENU)
            {
                System.out.println("MENU");
            }
            if (currentState == GameState.PLAYING)
            {
                System.out.println("PLAYING");
            }
            if (currentState == GameState.GAME_OVER)
            {
                System.out.println("GAME OVER");
            }
        }
    }
}
