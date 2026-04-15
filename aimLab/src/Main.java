import aimLab.Game;
import aimLab.Grid;
import aimLab.Position;
import aimLab.Target;
import com.codeforall.simplegraphics.graphics.Rectangle;

public class Main {
    public static void main(String[] args) {

        Game game = new Game();
        game.run();

        System.out.println("Let's shoot something");
        /*Game game;
        game = new Game();
        game.run();
        Rectangle rectangle;*/

        Grid grid = new Grid(25,25);
        grid.init();
        Target target = new Target(new Position(grid), grid);


    }
}
