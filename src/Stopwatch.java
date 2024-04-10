import javax.swing.*;
import java.awt.*;

public class Stopwatch {
    private final Dimension WINDOW_SIZE = new Dimension(250,50);
    public Stopwatch() {
        StopwatchFrame stopwatchFrame = new StopwatchFrame(WINDOW_SIZE);
        StopwatchGUI stopwatchGUI = new StopwatchGUI(WINDOW_SIZE);


        stopwatchFrame.add(stopwatchGUI.frontPanel);
        stopwatchFrame.add(stopwatchGUI.backPanel);
        stopwatchFrame.add(stopwatchGUI.backgroundPanel);

        stopwatchFrame.setVisible(true);

        StopwatchTimer stopwatchTimer = new StopwatchTimer(stopwatchGUI.stopwatchLabel);
        new StopwatchController( stopwatchFrame,stopwatchTimer);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Stopwatch::new);
    }
}






