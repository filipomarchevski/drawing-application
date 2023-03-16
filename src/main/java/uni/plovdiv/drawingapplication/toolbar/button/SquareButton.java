package uni.plovdiv.drawingapplication.toolbar.button;

import uni.plovdiv.drawingapplication.canvas.shape.Square;
import uni.plovdiv.drawingapplication.design.icon.SquareIcon;

import javax.swing.*;

import static uni.plovdiv.drawingapplication.design.icon.IconSize.ICON_HEIGHT;
import static uni.plovdiv.drawingapplication.design.icon.IconSize.ICON_WIDTH;

public class SquareButton extends JButton {

    public SquareButton(JPanel canvas) {
        super(new SquareIcon(ICON_WIDTH, ICON_HEIGHT));
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setFocusable(false);
        this.addActionListener(action -> new Square().draw(canvas));
    }
}
