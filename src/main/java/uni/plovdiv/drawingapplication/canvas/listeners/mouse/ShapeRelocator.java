package uni.plovdiv.drawingapplication.canvas.listeners.mouse;

import uni.plovdiv.drawingapplication.canvas.listeners.SelectedShapeState;
import uni.plovdiv.drawingapplication.canvas.shape.ShapeRepository;
import uni.plovdiv.drawingapplication.design.ColorPalette;

import java.awt.*;
import java.awt.event.MouseEvent;

import static uni.plovdiv.drawingapplication.canvas.listeners.SelectedShapeState.selectedShape;

public class ShapeRelocator {

    public void relocateSingleShape(MouseEvent event) {
        Graphics2D graphics2D = extractGraphics(event);
        Rectangle relocatedShape = relocateShapeBoundsCoordinates(event);
        graphics2D.draw(relocatedShape);
        removePreviousShape(selectedShape.getBounds(), graphics2D);
        ShapeRepository.updateRepository(selectedShape, relocatedShape);
        selectedShape = null;
    }

    /**
     * relocatedMainShape - The shape based on which the other ones will move.
     */
    public void relocateMultipleShapes(MouseEvent event) {
        Graphics2D graphics2D = extractGraphics(event);
        Rectangle relocatedMainShapeBounds = relocateShapeBoundsCoordinates(event);
        relocateOtherShapesBasedOnMainShape(relocatedMainShapeBounds, graphics2D);

    }

    private void relocateOtherShapesBasedOnMainShape(Rectangle relocatedMainShapeBounds, Graphics2D graphics2D) {
        var updatedShapes = SelectedShapeState.selectedShapes
                .stream()
                .map(shape -> calculateNewCoordinates(relocatedMainShapeBounds, shape))
                .toList();
        updatedShapes.forEach(graphics2D::draw);
    }

    private Shape calculateNewCoordinates(Rectangle relocatedMainShapeBounds, Shape shapeToRelocate) {
        Rectangle shapeToRelocateOldCoordinates = new Rectangle(shapeToRelocate.getBounds());
        Rectangle mainShapeOldCoordinates = selectedShape.getBounds();

        int differenceInX = mainShapeOldCoordinates.x - shapeToRelocateOldCoordinates.x;
        int differenceInY = mainShapeOldCoordinates.y - shapeToRelocateOldCoordinates.y;
        int newX = relocatedMainShapeBounds.x - differenceInX;
        int newY = relocatedMainShapeBounds.y - differenceInY;
        var relocatedShape = shapeToRelocate.getBounds();
        relocatedShape.x = newX;
        relocatedShape.y = newY;
        return relocatedShape;
    }

    private Rectangle relocateShapeBoundsCoordinates(MouseEvent event) {
        Rectangle selectedShapeBounds = selectedShape.getBounds();
        selectedShapeBounds.x = event.getX();
        selectedShapeBounds.y = event.getY();
        return selectedShapeBounds;
    }

    private void removePreviousShape(Rectangle shapeBounds, Graphics2D graphics2D) {
        graphics2D.setPaint(ColorPalette.WHITE);
        graphics2D.draw(shapeBounds);
    }

    private Graphics2D extractGraphics(MouseEvent event) {
        return (Graphics2D) event.getComponent().getGraphics();
    }
}
