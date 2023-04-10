package uni.plovdiv.drawingapplication.canvas.shape;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class ShapeRepository {

    /**
     * The Class<?> will be the actual class of the shape, ex: Square, Triangle ...
     */
    private static final Map<Shape, Class<?>> shapes = new HashMap<>();

    public static Optional<Shape> selectShape(int x, int y) {
        Set<Shape> storedShapes = shapes.keySet();
        return storedShapes
                .stream()
                .filter(shape -> shape.getBounds().contains(x, y))
                .findFirst();
    }

    public static void addShape(Shape shape, Class<?> typeOfShape) {
        shapes.put(shape, typeOfShape);
    }

    public static Class<?> removeShape(Shape shape) {
        return shapes.remove(shape);
    }

    public static void updateRepository(Shape oldShape, Shape newShape) {
        Class<?> oldShapeType = ShapeRepository.removeShape(oldShape);
        ShapeRepository.addShape(newShape, oldShapeType);
    }
}
