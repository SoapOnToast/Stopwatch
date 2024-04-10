import javax.swing.*;
import java.awt.*;

public class StopwatchFrame extends JFrame {
    public StopwatchFrame(int width, int height){
        PropertiesManager props = PropertiesManager.getInstance();
        String title = props.getStr("window.title");
        Image icon = props.getImage("window.icon");

        setLayout(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(width, height);

        setLocationRelativeTo(null);
        setLocation(getX(),0);
        setUndecorated(true);
        setAlwaysOnTop(true);

        setIconImage(icon);
        setTitle(title);
    }
}

