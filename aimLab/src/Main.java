import aimLab.Game;
import aimLab.Grid;
import com.codeforall.simplegraphics.graphics.Rectangle;

public class Main {
    public static void main() {

        System.out.println("Let's shoot something");
        /*Game game;
        game = new Game();
        game.run();
        Rectangle rectangle;*/

        Grid grid = new Grid(25,25);
        grid.init();



    }
}
