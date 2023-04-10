package uni.plovdiv.drawingapplication.toolbar.button;

import lombok.RequiredArgsConstructor;
import uni.plovdiv.drawingapplication.canvas.listeners.SelectedShapeState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorButton extends Button {

    public ColorButton(Component canvas, Component applicationWindows) {
        this.setLabel("Color");
        this.addActionListener(new ColorButtonActionListener(canvas, applicationWindows));
    }
}

@RequiredArgsConstructor
class ColorButtonActionListener implements ActionListener {

    private final Component canvas;

    private final Component applicationWindows;

    @Override
    public void actionPerformed(ActionEvent e) {
        Color initialColor = Color.WHITE;
        Graphics2D graphics2D = (Graphics2D) canvas.getGraphics();
        Color color = JColorChooser.showDialog(canvas, "Select a color", initialColor);

        graphics2D.setPaint(color);
        SelectedShapeState.selectedShapes.forEach(graphics2D::fill);
        applicationWindows.requestFocus();
    }
}
