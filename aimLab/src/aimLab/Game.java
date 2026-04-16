package aimLab;
import java.util.List;

public class Game {

    enum GameState {
        MENU,
        PLAYING,
        GAME_OVER;
    }
    private GameState currentState;
    private GameMode gameMode;
    private MouseInput mouseInput;
    private Score score;

    public Game() {
        currentState = GameState.MENU;
    }

    public void init() {
        Grid grid = new Grid(15, 15);
        grid.init();
        score = new Score();
        gameMode = new ClassicMode(grid);
        gameMode.start();
        mouseInput = new MouseInput(this);
        mouseInput.init();
        KeyboardInput keyboard = new KeyboardInput();
        keyboard.initKeys();
    }

    public void run(){
        init();
        while (true){
            switch (currentState){
                case MENU:
                    handleMenu();
                    break;
                case PLAYING:
                    handlePlaying();
                    break;
                case GAME_OVER:
                    handleGameOver();
                    break;
            }
        }
    }

    private void handleMenu(){
        System.out.println("MENU");
        currentState = GameState.PLAYING;
    }

    private void handlePlaying(){
     /*   try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }*/
    }

    private void handleGameOver(){
        System.out.println("GAME OVER");
    }

    public boolean isRunning() {
        return currentState == GameState.PLAYING;
    }

    public List<Target> targets() {
        return gameMode.getTargets();
    }

    public void onTargetHit(Target target){
        target.Destroy();
        gameMode.getTargets().remove(target);
        gameMode.spawnNewTargets();
        score.add();
        System.out.println("Score: " + score.getScore());
    }
}