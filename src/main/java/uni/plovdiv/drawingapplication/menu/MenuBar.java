package uni.plovdiv.drawingapplication.menu;

import javax.swing.*;
import java.awt.*;

import static uni.plovdiv.drawingapplication.design.ColorPalette.LIGHT_GREEN;

public class MenuBar extends JPanel {

    public MenuBar() {
        this.setBackground(LIGHT_GREEN);
        this.setPreferredSize(new Dimension(0, 30));
    }
}
