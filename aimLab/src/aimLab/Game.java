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
    private Timer timer;
    private Grid grid;
    private Menu menu;
    private GameOverScreen gameOverScreen;

    public Game() {
        currentState = GameState.PLAYING;
    }

    public void init() {
        grid = new Grid(20, 15);
        grid.init();
        score = new Score();
        timer = new Timer(this,10);
        timer.start();
        gameMode = new ClassicMode(grid);
        gameMode.start();
        gameOverScreen = new GameOverScreen();
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
    }
    private void handlePlaying(){
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
    public void gameOver() {
        currentState = GameState.GAME_OVER;
        timer.stop();
        for (Target t : targets()){
            t.Destroy();
        }
        gameMode.getTargets().clear();

        gameOverScreen.show(score.getScore());
        System.out.println("GAME OVER");
        System.out.println("FINAL SCORE: " + score.getScore());
    }
}