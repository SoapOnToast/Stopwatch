import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class Stopwatch {
    private final Color BACKGROUND  = new Color(27,27,27);
    public Stopwatch() {
        StopwatchFrame stopwatchFrame = new StopwatchFrame();

        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/icon.png"));
        stopwatchFrame.setIconImage(icon);
        stopwatchFrame.setTitle("Stopwatch");

        JPanel background = new JPanel(null,true);
        background.setBackground(BACKGROUND);
        background.setBounds(0,0,stopwatchFrame.width,stopwatchFrame.height);

        StopwatchPanel frontPanel = new StopwatchPanel(stopwatchFrame);
        StopwatchPanel backPanel = new StopwatchPanel(stopwatchFrame);

        backPanel.setBack();
        frontPanel.setFront();

        stopwatchFrame.add(frontPanel);
        stopwatchFrame.add(backPanel);
        stopwatchFrame.add(background);
        stopwatchFrame.setVisible(true);

        StopwatchTimer stopwatchTimer = new StopwatchTimer(frontPanel.getTimerLabel());
        StopwatchController stopwatchController = new StopwatchController( stopwatchFrame,stopwatchTimer);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Stopwatch stopwatchApp = new Stopwatch();
        });
    }
}






