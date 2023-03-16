package uni.plovdiv.drawingapplication;

import uni.plovdiv.drawingapplication.canvas.Canvas;
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
        JPanel canvas = new Canvas();
        this.add(canvas, BorderLayout.CENTER);
        this.add(new ToolBar(canvas), BorderLayout.WEST);
    }
}
