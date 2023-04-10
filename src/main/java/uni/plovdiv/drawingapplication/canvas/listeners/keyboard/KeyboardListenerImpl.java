package uni.plovdiv.drawingapplication.canvas.listeners.keyboard;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static java.lang.Character.toUpperCase;
import static uni.plovdiv.drawingapplication.canvas.listeners.ListenerConstants.movingMultipleShapesBasedOnOne;
import static uni.plovdiv.drawingapplication.canvas.listeners.ListenerConstants.movingSingleShape;
import static uni.plovdiv.drawingapplication.canvas.listeners.ListenerConstants.selectingMultipleShapes;

public class KeyboardListenerImpl extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent event) {
        char pressedKey = event.getKeyChar();
        switch (toUpperCase(pressedKey)) {
            case 'S' -> {
                movingSingleShape = false;
                selectingMultipleShapes = true;
            }
            case 'M' -> movingMultipleShapesBasedOnOne = true;
            case 'Q' -> {
                movingSingleShape = true;
                selectingMultipleShapes = false;
                movingMultipleShapesBasedOnOne = false;
            }
        }
    }
}
