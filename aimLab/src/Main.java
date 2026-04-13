import aimLab.*;
import com.codeforall.simplegraphics.graphics.Rectangle;
import com.codeforall.simplegraphics.pictures.Picture;

public class Main {
    public static void main() {

        System.out.println("Let's shoot something");
        /*Game game;
        game = new Game();
        game.run();
        Rectangle rectangle;*/

        Game game = new Game();
        game.start();
        KeyboardInput keyboard = new KeyboardInput();
        keyboard.initKeys();

        /*Grid grid = new Grid(25,25);
        grid.init();

        Target target = new Target(new Position(grid), grid, new Picture(0.2, 0.2, "aimLab/resources/sphere.png"));

        MouseInput mouse = new MouseInput();
        mouse.init();
        mouse.setTarget(target);*/






    }


}
