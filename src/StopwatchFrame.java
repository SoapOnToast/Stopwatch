import javax.swing.*;
import java.awt.*;

public class StopwatchFrame extends JFrame {
    private final String TITLE = "Stopwatch";
    private final String ICON_PATH = "/images/icon.png";
    public StopwatchFrame(Dimension dimension){
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(dimension.width, dimension.height);

        setLocationRelativeTo(null);
        setLocation(getX(),0);
        setUndecorated(true);
        setAlwaysOnTop(true);

        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource(ICON_PATH));
        setIconImage(icon);
        setTitle(TITLE);
    }
}

