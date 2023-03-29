package uni.plovdiv.drawingapplication.canvas.utils;

import javax.swing.*;
import java.util.List;

public class CoordinatesGenerator {

    /**
     * The first parameter will always be the X, and the second one Y.
     * @return the coordinates of the center of the canvas.
     */
    public static List<Integer> generateCoordinates(JPanel canvas) {
        int centeredX = (canvas.getWidth() - canvas.getX()) / 2;
        int centeredY = (canvas.getHeight() - canvas.getY()) / 2;
        return List.of(centeredX, centeredY);
    }
}
