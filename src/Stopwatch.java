import javax.swing.*;
import java.awt.*;

public class Stopwatch {
    public Stopwatch() {
        PropertiesManager props = PropertiesManager.getInstance();

        int width = props.getInt("window.width");
        int height = props.getInt("window.height");

        StopwatchFrame stopwatchFrame = new StopwatchFrame(width,height);
        StopwatchGUI stopwatchGUI = new StopwatchGUI(width,height);

        stopwatchFrame.add(stopwatchGUI.frontPanel);
        stopwatchFrame.add(stopwatchGUI.backPanel);
        stopwatchFrame.add(stopwatchGUI.backgroundPanel);

        stopwatchFrame.setVisible(true);

        StopwatchTimer stopwatchTimer = new StopwatchTimer(stopwatchGUI.stopwatchLabel);
        new StopwatchController(stopwatchFrame,stopwatchTimer);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Stopwatch::new);
    }
}






