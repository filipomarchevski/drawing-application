package uni.plovdiv.drawingapplication.canvas.listeners.mouse;

import uni.plovdiv.drawingapplication.canvas.shape.ShapeRepository;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Optional;

import static uni.plovdiv.drawingapplication.canvas.listeners.ListenerConstants.selectingMultiple;
import static uni.plovdiv.drawingapplication.canvas.listeners.SelectedShapeState.selectedShape;

public class OnPressEvent {

    public void press(MouseEvent event) {
        if (!selectingMultiple) {
            Optional<Shape> retrievedShape = ShapeRepository.selectShape(event.getX(), event.getY());
            retrievedShape.ifPresent(shape -> selectedShape = shape);
        }
    }
}
