package uni.plovdiv.drawingapplication.canvas.shape;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static uni.plovdiv.drawingapplication.canvas.utils.CoordinatesGenerator.generateCoordinates;

public class Square {

    public void draw(JPanel canvas) {
        Shape square = createSquare(canvas);
        Graphics2D graphics2D = (Graphics2D) canvas.getGraphics();
        graphics2D.draw(square);
        ShapeRepository.shapes.put(square, Square.class);
    }

    private Shape createSquare(JPanel canvas) {
        int initialSideSize = 120;
        List<Integer> coordinates = generateCoordinates(canvas);
        return new Rectangle(
                coordinates.get(0),
                coordinates.get(1),
                initialSideSize,
                initialSideSize
        );
    }
}
