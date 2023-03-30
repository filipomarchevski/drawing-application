package uni.plovdiv.drawingapplication.canvas.listeners.mouse;

import java.awt.event.MouseEvent;
import java.util.Objects;

import static uni.plovdiv.drawingapplication.canvas.listeners.SelectedShapeState.selectedShape;
import static uni.plovdiv.drawingapplication.canvas.listeners.SelectedShapeState.selectedShapes;

public class OnReleaseEvent {

    private final SingleShapeMover singleShapeMover = new SingleShapeMover();

    private final MultipleShapesMover multipleShapesMover = new MultipleShapesMover();

    public void release(MouseEvent event) {
        if (!Objects.isNull(selectedShape)) {
            singleShapeMover.moveSingleShape(event);
        } else if (!selectedShapes.isEmpty()) {
            multipleShapesMover.moveMultipleShapes();
        }
    }
}
