import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StopwatchTimer{
    public Timer timer;
    private long startTime;
    private long startPause;
    private final StopwatchLabel stopwatchLabel;
    public StopwatchTimer(StopwatchLabel stopwatchLabel) {
        this.stopwatchLabel = stopwatchLabel;
    }

    public void startTimer() {
        startTime = System.currentTimeMillis(); // Get the current time in milliseconds
        timer = new Timer(10, new ActionListener() { // Update the timer every 10 milliseconds for better accuracy
            @Override
            public void actionPerformed(ActionEvent e) {
                long elapsedTime = System.currentTimeMillis() - startTime; // Calculate the elapsed time
                long mili = elapsedTime % 1000;
                int seconds = (int) (elapsedTime / 1000) % 60;
                int minutes = (int) (elapsedTime / 1000 / 60) % 60;
                int hours = (int) (elapsedTime / 1000 / 60 / 60) % 60;
                stopwatchLabel.setText(String.format("%02d:%02d:%02d.%03d", hours, minutes, seconds, mili));
            }
        });
        timer.start();
    }
    public void pauseTimer(){
        if (timer.isRunning()) {
            timer.stop();
            startPause = System.currentTimeMillis();
        } else {
            long endPause = System.currentTimeMillis();
            startTime += endPause - startPause; // Reset startTime to current time
            timer.start();
        }
    }
    public void resetTimer(){
        stopwatchLabel.setText("");
    }
}
