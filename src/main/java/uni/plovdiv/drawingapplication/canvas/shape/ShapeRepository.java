package uni.plovdiv.drawingapplication.canvas.shape;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ShapeRepository {

    /**
     * The Class<?> will be the actual class of the shape, ex: Square, Triangle ...
     */
    public static final Map<Shape, Class<?>> shapes = new HashMap<>();
}
