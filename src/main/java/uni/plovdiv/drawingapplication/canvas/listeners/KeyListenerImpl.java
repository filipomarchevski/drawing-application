package uni.plovdiv.drawingapplication.canvas.listeners;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static java.lang.Character.toUpperCase;
import static uni.plovdiv.drawingapplication.canvas.listeners.ListenerConstants.*;

public class KeyListenerImpl extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
        char pressedKey = e.getKeyChar();
        switch (toUpperCase(pressedKey)) {
            case 'S' -> selectingMultiple = true;
            case 'Q' -> selectingMultiple = false;
        }
    }
}
