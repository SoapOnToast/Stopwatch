import javax.swing.*;
import java.awt.*;

class StopwatchGUI {
    private int padding = 5;
    private final Font stopwatch_font = Utils.loadCustomFont("fonts/DSEG7Classic-Regular.ttf", 30);
    public final Color DIGIT_ACTIVE = new Color(204,0,51);
    public final Color DIGIT_INACTIVE = new Color(80, 9, 23);
    private final Color DIGIT_BACKGROUND  = new Color(58, 5, 17);
    private final Color BACKGROUND  = new Color(27,27,27);
    public StopwatchLabel stopwatchLabel;
    private final StopwatchLabel stopwatchLabelBg;
    public JPanel frontPanel;
    public JPanel backPanel;
    public final JPanel backgroundPanel;

    public StopwatchGUI(Dimension windowSize) {
        backgroundPanel = createBackground(windowSize);

        stopwatchLabelBg = new StopwatchLabel("00:00:00.000", stopwatch_font, DIGIT_INACTIVE);
        stopwatchLabel = new StopwatchLabel("", stopwatch_font, DIGIT_ACTIVE);

        frontPanel = createFrontPanel(windowSize);
        backPanel = createBackPanel(windowSize);
    }
    private JPanel createBackground(Dimension windowSize){
        JPanel background = new JPanel(null,true);
        background.setBackground(BACKGROUND);
        background.setBounds(0,0,windowSize.width,windowSize.height);
        return background;
    }
    public JPanel createFrontPanel(Dimension windowSize){
        int width = windowSize.width - 2 * padding;
        int height = windowSize.height - 2 * padding;
        JPanel panel = new JPanel();
        panel.setBounds(padding,padding,width,height);
        panel.add(stopwatchLabel);
        panel.setOpaque(false);
        return panel;
    }
    public JPanel createBackPanel(Dimension windowSize){
        int width = windowSize.width - 2 * padding;
        int height = windowSize.height - 2 * padding;
        JPanel panel = new JPanel();
        panel.setBounds(padding,padding,width,height);
        panel.add(stopwatchLabelBg);
        panel.setBackground(DIGIT_BACKGROUND);
        return panel;
    }
}