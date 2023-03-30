package uni.plovdiv.drawingapplication.canvas.listeners.mouse;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseListenerImpl extends MouseAdapter {

    private final OnClickEvent onClickEvent = new OnClickEvent();

    private final OnPressEvent onPressEvent = new OnPressEvent();

    private final OnReleaseEvent onReleaseEvent = new OnReleaseEvent();

    @Override
    public void mouseClicked(MouseEvent event) {
        onClickEvent.click(event);
    }

    /**
     * Sets the selectedShape state, so it can be processed by the mouse release event.
     */
    @Override
    public void mousePressed(MouseEvent event) {
        onPressEvent.press(event);
    }

    /**
     * If the selectedShape has state, it will move the shape to where the mouse clicked on the JPanel.
     */
    @Override
    public void mouseReleased(MouseEvent event) {
        onReleaseEvent.release(event);
    }
}
