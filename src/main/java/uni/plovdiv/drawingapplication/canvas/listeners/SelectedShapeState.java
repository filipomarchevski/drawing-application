package uni.plovdiv.drawingapplication.canvas.listeners;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class SelectedShapeState {

    public static Shape selectedShape;
    
    public static final Set<Shape> selectedShapes = new HashSet<>();
}
