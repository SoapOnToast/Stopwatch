import javax.swing.*;
import java.awt.*;

public class StopwatchFrame extends JFrame {
    public int height;
    public int width;
    public StopwatchFrame() throws HeadlessException {
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        float SCALING_FACTOR = 0.0447f;
        height = Math.round(SCALING_FACTOR * screenHeight);

        width = Math.round(height * 5f);
        setSize(width, height);

        setLocationRelativeTo(null);
        setLocation(getX(),0);
        setUndecorated(true);
        setAlwaysOnTop(true);
    }
}

