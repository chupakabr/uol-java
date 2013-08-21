import javax.swing.*;
import java.awt.*;

/**
 * Write a program that bounces a blue ball inside a JPanel. The ball should begin moving with a mousePressed event.
 * When the ball hits the edge of the JPanel, it should bounce off the edge and continue in the opposite direction.
 * The ball should be updated using a Runnable.
 *
 * Created by myltik
 * Created on 8/21/13 3:48 PM
 */
public class W07A1App implements Runnable {

    private final int WIDTH = 150;
    private final int HEIGHT = 150;

    private final DrawingPanel drawingPanel;

    public W07A1App() {
        drawingPanel = new DrawingPanel(WIDTH, HEIGHT, new Ball());
    }

    /**
     * Render GUI
     */
    @Override
    public void run() {
        render();

        // Create tick thread
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                while (true) {
                    try {
                        Thread.sleep(10l);
                        drawingPanel.repaint();
                    } catch (InterruptedException e) {
                        // ignore
                        LogUtil.w("Tick thread received InterruptedException, ignoring it and continue...");
                    }
                }
            }
        }.execute();
    }

    /**
     * Ask user for input. Also display evaluation result.
     */
    private void render() {
        JFrame frame = new JFrame("Bouncing Ball");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(drawingPanel);
        frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        frame.pack();
        frame.setResizable(true);
        frame.setVisible(true);
    }
}
