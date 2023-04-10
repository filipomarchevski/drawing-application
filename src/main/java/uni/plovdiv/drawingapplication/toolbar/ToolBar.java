package uni.plovdiv.drawingapplication.toolbar;

import uni.plovdiv.drawingapplication.toolbar.button.ColorButton;
import uni.plovdiv.drawingapplication.toolbar.button.SquareButton;

import javax.swing.*;
import java.awt.*;

import static uni.plovdiv.drawingapplication.design.ColorPalette.BLUE;

public class ToolBar extends JPanel {

    public ToolBar(JPanel canvas, Component applicationWindows) {
        this.setBackground(BLUE);
        this.setPreferredSize(new Dimension(150, 0));
        this.add(new SquareButton(canvas));
        this.add(new ColorButton(canvas ,applicationWindows));
    }
}
