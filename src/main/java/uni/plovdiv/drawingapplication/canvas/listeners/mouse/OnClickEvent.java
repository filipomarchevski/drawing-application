package uni.plovdiv.drawingapplication.canvas.listeners.mouse;

import uni.plovdiv.drawingapplication.canvas.shape.ShapeRepository;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Optional;

import static uni.plovdiv.drawingapplication.canvas.listeners.ListenerConstants.selectingMultipleShapes;
import static uni.plovdiv.drawingapplication.canvas.listeners.SelectedShapeState.selectedShapes;

public class OnClickEvent {

    public void click(MouseEvent event) {
        if (selectingMultipleShapes) {
            Optional<Shape> retrievedShape = ShapeRepository.selectShape(event.getX(), event.getY());
            retrievedShape.ifPresent(selectedShapes::add);
        }
    }
}
