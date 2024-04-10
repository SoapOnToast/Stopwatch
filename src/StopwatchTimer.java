import javax.swing.*;

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
        // Update the timer every 10 milliseconds for better accuracy
        timer = new Timer(10, e -> {
            long elapsedTime = System.currentTimeMillis() - startTime; // Calculate the elapsed time
            long millis = elapsedTime % 1000;
            int seconds = (int) (elapsedTime / 1000) % 60;
            int minutes = (int) (elapsedTime / 1000 / 60) % 60;
            int hours = (int) (elapsedTime / 1000 / 60 / 60) % 60;
            stopwatchLabel.setText(String.format("%02d:%02d:%02d.%03d", hours, minutes, seconds, millis));
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
