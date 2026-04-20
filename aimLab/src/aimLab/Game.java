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
        currentState = GameState.MENU;
        menu = new Menu();
        gameOverScreen = new GameOverScreen();
    }

    public void init() {
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
        menu.show();
    }
    private void handlePlaying(){
    }

    private void handleGameOver(){
        System.out.println("GAME OVER");
    }

    public void startGame(){
        menu.hide();
        grid = new Grid(20,15);
        grid.init();
        score = new Score();
        gameMode = new ClassicMode(grid);
        gameMode.start();
        timer = new Timer(this,60);
        timer.start();

        currentState = GameState.PLAYING;
    }

    public boolean isRunning() {
        return currentState == GameState.PLAYING;
    }

    public boolean isGameOver() {
        return currentState == GameState.GAME_OVER;
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