package uni.plovdiv.drawingapplication.canvas.listeners.mouse;

import uni.plovdiv.drawingapplication.canvas.shape.ShapeRepository;
import uni.plovdiv.drawingapplication.design.ColorPalette;

import java.awt.*;
import java.awt.event.MouseEvent;

import static uni.plovdiv.drawingapplication.canvas.listeners.SelectedShapeState.selectedShape;

public class SingleShapeMover {

    public void moveSingleShape(MouseEvent event) {
        Graphics2D graphics = (Graphics2D) (event.getComponent().getGraphics());
        Shape movedShape = moveOldShape(event, graphics);
        removePreviousShape(graphics);
        updateShapeRepository(movedShape);
        selectedShape = null;
    }

    private Shape moveOldShape(MouseEvent event, Graphics2D graphics) {
        Rectangle movedShape = moveShapeCoordinates(event);
        graphics.draw(movedShape);
        return movedShape;
    }

    private Rectangle moveShapeCoordinates(MouseEvent event) {
        Rectangle selectedShapeBounds = selectedShape.getBounds();
        selectedShapeBounds.x = event.getX();
        selectedShapeBounds.y = event.getY();
        return selectedShapeBounds;
    }

    private void removePreviousShape(Graphics2D graphics2D) {
        Rectangle selectedShapeBounds = selectedShape.getBounds();
        graphics2D.setPaint(ColorPalette.WHITE);
        graphics2D.draw(selectedShapeBounds);
    }

    private void updateShapeRepository(Shape newShape) {
        Class<?> oldShapeType = ShapeRepository.removeShape(selectedShape);
        ShapeRepository.addShape(newShape, oldShapeType);
    }
}
