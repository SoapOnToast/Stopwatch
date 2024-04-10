import javax.swing.*;
import java.awt.*;

public class Stopwatch {
    private final Dimension WINDOW_SIZE = new Dimension(250,50);
    public Stopwatch() {
        //setup frames
        StopwatchFrame stopwatchFrame = new StopwatchFrame(WINDOW_SIZE);
        StopwatchGUI stopwatchGUI = new StopwatchGUI(WINDOW_SIZE);
        //add gui elements
        stopwatchFrame.add(stopwatchGUI.frontPanel);
        stopwatchFrame.add(stopwatchGUI.backPanel);
        stopwatchFrame.add(stopwatchGUI.backgroundPanel);
        //enable frame
        stopwatchFrame.setVisible(true);
        //link logic and controls
        StopwatchTimer stopwatchTimer = new StopwatchTimer(stopwatchGUI.stopwatchLabel);
        new StopwatchController(stopwatchFrame,stopwatchTimer);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Stopwatch::new);
    }
}






