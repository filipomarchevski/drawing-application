package uni.plovdiv.drawingapplication.toolbar;

import javax.swing.*;

import java.awt.*;

import static uni.plovdiv.drawingapplication.design.ColorPalette.LIGHT_GREEN;

public class ToolBar extends JPanel {

    public ToolBar() {
        this.setBackground(LIGHT_GREEN);
        this.setPreferredSize(new Dimension(150, 0));
    }
}
