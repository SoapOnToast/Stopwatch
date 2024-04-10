import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StopwatchController{
    private Point mouseDownCompCoords = null;
    public boolean running = false;
    public StopwatchController(StopwatchFrame stopwatchFrame, StopwatchTimer stopwatchTimer) {
        stopwatchFrame.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mouseDownCompCoords = e.getPoint();
            }

            public void mouseReleased(MouseEvent e) {
                mouseDownCompCoords = null;
            }
        });
        stopwatchFrame.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point currCoords = e.getLocationOnScreen();
                int newX = currCoords.x - mouseDownCompCoords.x;
                int newY = currCoords.y - mouseDownCompCoords.y;

                // Ensure the window does not go off-screen
                GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
                Rectangle bounds = gd.getDefaultConfiguration().getBounds();
                newY = Math.max(bounds.y, Math.min(newY, bounds.y + bounds.height - stopwatchFrame.getHeight()));
                newX = Math.max(bounds.x, Math.min(newX, bounds.x + bounds.width - stopwatchFrame.getWidth()));

                stopwatchFrame.setLocation(newX, newY);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        stopwatchFrame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            public void keyPressed(KeyEvent e) {
                // Invoked when a key is pressed
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_SPACE) {
                    if (running){
                        stopwatchTimer.pauseTimer();
                    }else {
                        stopwatchTimer.startTimer();
                        running = true;
                    }
                }
                else if (keyCode == KeyEvent.VK_ESCAPE){
                    if (stopwatchTimer.timer != null && !stopwatchTimer.timer.isRunning()){
                        stopwatchTimer.resetTimer();
                        running = false;
                    }
                }
                else if (keyCode == KeyEvent.VK_BACK_SPACE){
                    System.exit(0);
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }
}