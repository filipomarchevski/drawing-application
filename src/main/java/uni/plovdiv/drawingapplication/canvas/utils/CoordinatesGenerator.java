package uni.plovdiv.drawingapplication.canvas.utils;

import javax.swing.*;
import java.util.List;
import java.util.Random;

public class CoordinatesGenerator {

    /**
     * The first parameter will always be the X, and the second one Y.
     */
    public static List<Integer> generateCoordinates(JPanel canvas, int size) {
        int x = generateCoordinate(canvas.getX(), canvas.getWidth(), size);
        int y = generateCoordinate(canvas.getY(), canvas.getHeight(), size);
        return List.of(x, y);
    }

    private static int generateCoordinate(int minCoordinate, int maxCoordinate, int size) {
        return new Random().nextInt(maxCoordinate - minCoordinate - size) + minCoordinate;
    }
}
