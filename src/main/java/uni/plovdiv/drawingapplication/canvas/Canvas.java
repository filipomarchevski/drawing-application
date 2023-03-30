package uni.plovdiv.drawingapplication.canvas;

import uni.plovdiv.drawingapplication.canvas.listeners.mouse.MouseListenerImpl;

import javax.swing.*;

import static uni.plovdiv.drawingapplication.design.ColorPalette.WHITE;

public class Canvas extends JPanel {

    public Canvas() {
        this.setBackground(WHITE);
        this.addMouseListener(new MouseListenerImpl());
    }
}
