package aimLab;
import aimLab.GameMods.Practice;
import aimLab.UtilityResources.GameOverScreen;
import aimLab.UtilityResources.SelectScreen;
import aimLab.UtilityResources.Sound;
import aimLab.UtilityResources.StartScreen;
import aimLab.Inputs.KeyboardInput;

import java.util.List;

public class Game {

    enum GameState {
        STARTSCREEN,
        MENU,
        SELECT,
        PLAYING,
        GAME_OVER;
    }

    private GameState currentState;

    private GameMode gameMode;
    public MouseInput mouseInput;
    private Score score;
    private Timer timer;
    private Grid grid;
    private StartScreen startScreen;
    private SelectScreen selectScreen;
    private GameOverScreen gameOverScreen;
    private Sound menuMusic;
    private boolean musicPlaying = false;

    public Game() {
        currentState = GameState.STARTSCREEN;
        startScreen = new StartScreen();
        selectScreen = new SelectScreen();
        gameOverScreen = new GameOverScreen();
        menuMusic = new Sound("aimLab/resources/musica-aim-_4_.wav");
        System.out.println(currentState);
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

                case STARTSCREEN:
                    handleStart();
                    break;

                case MENU:
                    handleMenu();
                    break;

                case SELECT:
                    handleSelect();
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

    public GameState getState(){
        return currentState;
    }

    private void handleStart(){
        startScreen.show();
        if (!musicPlaying){
            menuMusic.playLoop();
            musicPlaying = true;
        }
    }

    private void handleMenu(){
        if (!musicPlaying){
            menuMusic.playLoop();
            musicPlaying = true;
        }
    }

    private void handleSelect(){
        if (!musicPlaying){
            menuMusic.playLoop();
            musicPlaying = true;
        }
    }

    private void handlePlaying(){

        if (gameMode == null) {
            return;
        }
    }

    private void handleGameOver(){
        System.out.println("GAME OVER");
    }

    public void goToSelect() {
        startScreen.hide();
        selectScreen.show();
        currentState = GameState.SELECT;
    }

    public void startGame(){

        selectScreen.hide();

        if (menuMusic != null){
            menuMusic.stop();
            musicPlaying = false;
        }

        grid = new Grid(20, 15);
        grid.init();

        score = new Score();

        gameMode = new Practice(grid);
        gameMode.setDisappearTimer(2000, 3);
        gameMode.start();

        timer = new Timer(this, 50);
        timer.start();

        currentState = GameState.PLAYING;
    }

    public void restartGame(){
        gameOverScreen.hide();
        score.hideScore();
        startGame();
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

    public void onTargetHit(Target target) {
        target.Destroy();
        gameMode.getTargets().remove(target);

        score.add();

        new Thread(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ignored) {}

            gameMode.spawnNewTargets();
        }).start();
    }

    public void gameOver() {
        currentState = GameState.GAME_OVER;
        timer.stop();

        for (Target t : targets()){
            t.Destroy();
        }

        gameMode.getTargets().clear();
    }
}