import javax.swing.*;
import java.awt.*;

class StopwatchGUI {
    private final int padding;
    private final Color FOREGROUND_COLOR;
    private final Color BACKGROUND_COLOR;
    public StopwatchLabel stopwatchLabel;
    private final StopwatchLabel stopwatchLabelBg;
    public JPanel frontPanel;
    public JPanel backPanel;
    public final JPanel backgroundPanel;
    private final int width;
    private final int height;

    public StopwatchGUI(int width, int height) {
        this.width = width;
        this.height = height;

        PropertiesManager props = PropertiesManager.getInstance();
        String defaultText = props.getStr("text.default");

        padding = props.getInt("window.padding");

        Font stopwatch_font = props.getFont("text.font");

        Color digit_active = props.getColor("text.color.active");
        Color digit_inactive = props.getColor("text.color.inactive");

        BACKGROUND_COLOR = props.getColor("window.color.background");
        FOREGROUND_COLOR = props.getColor("window.color.foreground");

        backgroundPanel = createBackground();

        stopwatchLabelBg = new StopwatchLabel(defaultText, stopwatch_font, digit_inactive);
        stopwatchLabel = new StopwatchLabel("", stopwatch_font, digit_active);

        frontPanel = createFrontPanel();
        backPanel = createBackPanel();
    }
    private JPanel createBackground(){
        JPanel background = new JPanel(null,true);
        background.setBackground(BACKGROUND_COLOR);
        background.setBounds(0,0,width,height);
        return background;
    }
    public JPanel createFrontPanel(){
        int width = this.width - 2 * padding;
        int height = this.height - 2 * padding;
        JPanel panel = new JPanel();
        panel.setBounds(padding,padding,width,height);
        panel.add(stopwatchLabel);
        panel.setOpaque(false);
        return panel;
    }
    public JPanel createBackPanel(){
        int width = this.width - 2 * padding;
        int height = this.height - 2 * padding;
        JPanel panel = new JPanel();
        panel.setBounds(padding,padding,width,height);
        panel.add(stopwatchLabelBg);
        panel.setBackground(FOREGROUND_COLOR);
        return panel;
    }
}