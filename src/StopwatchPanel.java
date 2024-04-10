import javax.swing.*;
import java.awt.*;

class StopwatchPanel extends JPanel {
    public final Color DIGIT_ACTIVE = new Color(204,0,51);
    public final Color DIGIT_INACTIVE = new Color(80, 9, 23);
    private final Color DIGIT_BACKGROUND  = new Color(58, 5, 17);
    private final int padding = 5;
    private final StopwatchLabel stopwatchLabelBg;
    public StopwatchLabel stopwatchLabel;

    public StopwatchPanel(StopwatchFrame frame) {
        super(true);
        setBounds(padding, padding, frame.width - 2 * padding, frame.height - 2 * padding);

        int fontSize = Math.round(getHeight() * 0.75f);

        Font stopwatch_font = Utils.loadCustomFont("fonts/DSEG7Classic-Regular.ttf", fontSize);

        stopwatchLabelBg = new StopwatchLabel("00:00:00.000", stopwatch_font, DIGIT_INACTIVE);
        stopwatchLabel = new StopwatchLabel("", stopwatch_font, DIGIT_ACTIVE);
    }
    public StopwatchLabel getTimerLabel(){
        return stopwatchLabel;
    }
    public void setFront(){
        add(stopwatchLabel);
        setOpaque(false);
    }
    public void setBack(){
        setBackground(DIGIT_BACKGROUND);
        add(stopwatchLabelBg);

    }
}