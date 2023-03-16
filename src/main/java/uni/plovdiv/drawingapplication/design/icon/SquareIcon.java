package uni.plovdiv.drawingapplication.design.icon;

import lombok.RequiredArgsConstructor;

import javax.swing.*;
import java.awt.*;

@RequiredArgsConstructor
public class SquareIcon implements Icon {

    private final int width;

    private final int height;

    @Override
    public void paintIcon(Component component, Graphics graphics, int x, int y) {
        graphics.drawRect(x, y, width, height);
    }

    @Override
    public int getIconWidth() {
        return width;
    }

    @Override
    public int getIconHeight() {
        return height;
    }
}
