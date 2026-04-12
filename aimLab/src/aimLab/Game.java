package aimLab;

public class Game {

    enum GameState {
        MENU,
        PLAYING,
        GAME_OVER;
    }
    GameState currentState = GameState.MENU;

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
