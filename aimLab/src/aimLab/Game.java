package aimLab;

public class Game {

    enum GameState {
        MENU,
        PLAYING,
        GAME_OVER;
    }
    private GameState currentState;
    private GameMode gameMode;

    public Game() {
        currentState = GameState.MENU;
    }

    public void init() {
        Grid grid = new Grid(30, 30);
        grid.init();

        gameMode = new ClassicMode(grid);
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
        gameMode.start();
    }
    private void handlePlaying(){
        System.out.println("PLAYING");
    }
    private void handleGameOver(){
        System.out.println("GAME OVER");
    }

    public boolean isRunning() {
        return currentState == GameState.PLAYING;
    }

    public void onTargetHit(Target target){
        System.out.println("target hit");
        target.Destroy();
    }
}
