import javax.swing.*;
import java.awt.*;

public class StopwatchLabel extends JLabel {
    public StopwatchLabel(String text, Font font, Color color) {
        super(text);
        setFont(font);
        setForeground(color);
        setVerticalAlignment(SwingConstants.CENTER);
        setAlignmentY(Component.CENTER_ALIGNMENT);
    }
}