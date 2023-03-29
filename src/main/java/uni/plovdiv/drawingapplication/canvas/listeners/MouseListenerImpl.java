package uni.plovdiv.drawingapplication.canvas.listeners;

import uni.plovdiv.drawingapplication.canvas.shape.ShapeRepository;
import uni.plovdiv.drawingapplication.design.ColorPalette;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;
import java.util.Optional;

public class MouseListenerImpl implements MouseListener {

    private Shape selectedShape;

    @Override
    public void mouseClicked(MouseEvent event) {
    }

    /**
     * Sets the selectedShape state, so it can be processed by the mouse release event.
     */
    @Override
    public void mousePressed(MouseEvent event) {
        Optional<Shape> retrievedShape = ShapeRepository.selectShape(event.getX(), event.getY());
        retrievedShape.ifPresent((shape) -> selectedShape = shape);
    }

    /**
     * If the selectedShape has state, it will move the shape to where the mouse clicked on the JPanel.
     */
    @Override
    public void mouseReleased(MouseEvent event) {
        if (!Objects.isNull(selectedShape)) {
            Graphics2D graphics = (Graphics2D) (event.getComponent().getGraphics());
            Shape movedShape = moveOldShape(event, graphics);
            removePreviousShape(graphics);
            updateShapeRepository(movedShape);
            selectedShape = null;
        }
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

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
