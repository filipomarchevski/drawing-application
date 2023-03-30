package uni.plovdiv.drawingapplication.canvas.listeners.keyboard;

import uni.plovdiv.drawingapplication.canvas.listeners.SelectedShapeState;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static java.lang.Character.toUpperCase;
import static uni.plovdiv.drawingapplication.canvas.listeners.ListenerConstants.selectingMultiple;
import static uni.plovdiv.drawingapplication.canvas.listeners.ListenerConstants.selectingSingle;

public class KeyboardListenerImpl extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
        char pressedKey = e.getKeyChar();
        switch (toUpperCase(pressedKey)) {
            case 'S' -> {
                selectingSingle = false;
                selectingMultiple = true;
            }
            case 'Q' -> {
                selectingSingle = true;
                selectingMultiple = false;
                SelectedShapeState.selectedShapes.clear();
            }
        }
    }
}
