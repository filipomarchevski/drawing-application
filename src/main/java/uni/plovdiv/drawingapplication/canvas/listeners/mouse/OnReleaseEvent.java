package uni.plovdiv.drawingapplication.canvas.listeners.mouse;

import uni.plovdiv.drawingapplication.canvas.shape.ShapeRelocator;

import java.awt.event.MouseEvent;
import java.util.Objects;

import static uni.plovdiv.drawingapplication.canvas.listeners.SelectedShapeState.selectedShape;
import static uni.plovdiv.drawingapplication.canvas.listeners.SelectedShapeState.selectedShapes;

public class OnReleaseEvent {

    private final ShapeRelocator shapeRelocator = new ShapeRelocator();

    /**
     * If neither of the options are checked, it means that we don't want to move anything.
     */
    public void release(MouseEvent event) {
        if (shouldMoveMultipleShapes()) {
            shapeRelocator.relocateMultipleShapes(event);
        } else if (shouldMoveSingleShape()) {
            shapeRelocator.relocateSingleShape(event);
        }
    }

    /**
     * If the set with the selected shoes is not empty,
     * and we have selected a shape, based on which the other shapes will be moved,
     * then it moves them.
     */
    private boolean shouldMoveMultipleShapes() {
        return !Objects.isNull(selectedShape) && !selectedShapes.isEmpty();
    }

    /**
     * If we only have a selected shape, it will just move that one.
     */
    private boolean shouldMoveSingleShape() {
        return !Objects.isNull(selectedShape);
    }
}
