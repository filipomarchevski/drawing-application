package uni.plovdiv.drawingapplication;

import uni.plovdiv.drawingapplication.canvas.Canvas;
import uni.plovdiv.drawingapplication.menu.MenuBar;
import uni.plovdiv.drawingapplication.toolbar.ToolBar;

import javax.swing.*;
import java.awt.*;

import static uni.plovdiv.drawingapplication.design.ColorPalette.BEIGE;

/**
 * The main window for the application.
 */
public class ApplicationWindow extends JFrame {

    public ApplicationWindow() {
        setupApplicationWindowJFrame();
        addPanels();
    }

    private void setupApplicationWindowJFrame() {
        this.setVisible(true);
        this.setResizable(false);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(7, 7));
        this.getContentPane().setBackground(BEIGE);
    }

    private void addPanels() {
        this.add(new ToolBar(), BorderLayout.WEST);
        this.add(new Canvas(), BorderLayout.CENTER);
        this.add(new MenuBar(), BorderLayout.NORTH);
    }
}
