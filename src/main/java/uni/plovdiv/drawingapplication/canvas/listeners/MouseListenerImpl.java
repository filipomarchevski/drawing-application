package uni.plovdiv.drawingapplication.canvas.listeners;

import uni.plovdiv.drawingapplication.canvas.shape.ShapeRepository;

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

    @Override
    public void mousePressed(MouseEvent event) {
        Optional<Shape> retrievedShape = ShapeRepository.selectShape(event.getX(), event.getY());
        retrievedShape.ifPresent((shape) -> selectedShape = shape);
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        if (!Objects.isNull(selectedShape)) {
            Graphics2D graphics = (Graphics2D) (event.getComponent().getGraphics());
            Rectangle movedShape = moveShapeCoordinates(event);
            graphics.draw(movedShape);
            selectedShape = null;
        }
    }

    private Rectangle moveShapeCoordinates(MouseEvent event) {
        Rectangle selectedShapeBounds = selectedShape.getBounds();
        selectedShapeBounds.x = event.getX();
        selectedShapeBounds.y = event.getY();
        return selectedShapeBounds;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
