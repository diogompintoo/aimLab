package aimLab;

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
        Grid grid = new Grid(30, 30);
        grid.init();

        score = new Score();

        gameMode = new ClassicMode(grid);
        gameMode.start();

        mouseInput = new MouseInput(this);
        mouseInput.setTargets(gameMode.getTargets());
        mouseInput.init();
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
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void handleGameOver(){
        System.out.println("GAME OVER");
    }

    public boolean isRunning() {
        return currentState == GameState.PLAYING;
    }

    public void onTargetHit(Target target){
        gameMode.getTargets().remove(target);
        target.Destroy();
        score.add();
        System.out.println("Score: " + score.getScore());
    }
}