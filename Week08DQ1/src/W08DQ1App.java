import javax.swing.*;
import java.awt.*;

/**
 * Try to develop a new application to use the example given in Figure 8-1 (in the lecture note),
 * the new application should display one out of a possible 10 pictures in the window. User should
 * be able to choose the picture by position tick on the Slide bar.
 *
 * Created by myltik
 * Created on 8/23/13 5:38 PM
 */
public class W08DQ1App implements Runnable {

    private final String ASSETS_PATH = "./assets";
    //private final String ASSETS_PATH = "/Users/myltik/Dev/MyProjects/UolJava/out/production/Week08DQ1/assets";

    private static final int WIDTH = 480;
    private static final int HEIGHT = 570;

    public W08DQ1App() {
    }

    /**
     * Render GUI
     */
    @Override
    public void run() {
        try {
            render();
        } catch (CannotLoadImageException e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Ask user for input. Also display evaluation result.
     */
    private void render() throws CannotLoadImageException {
        JFrame frame = new JFrame("Image View");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new ImageViewer(new BundledImageLoader(ASSETS_PATH)));
        frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
