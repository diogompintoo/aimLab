package aimLab;

import com.codeforall.simplegraphics.keyboard.Keyboard;
import com.codeforall.simplegraphics.keyboard.KeyboardEvent;
import com.codeforall.simplegraphics.keyboard.KeyboardEventType;
import com.codeforall.simplegraphics.keyboard.KeyboardHandler;


public class KeyboardInput implements KeyboardHandler {

    private Keyboard keyboard;

    public KeyboardInput() {
        this.keyboard = new Keyboard(this);
    }

    public void initKeys(){
        KeyboardEvent quit = new KeyboardEvent();
        quit.setKey(KeyboardEvent.KEY_ESC);
        quit.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(quit);

    }
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_ESC){
            System.exit(0);
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
