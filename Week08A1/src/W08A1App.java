import javax.swing.*;
import java.awt.*;

/**
 * Design a drawing application (have a look at Microsoft Paint application on your Windows system).
 * The application must have menus, and must be able to draw one or more sharps (e. g. point, line,
 * rectangle, oval, etc).
 * The application should use GUI components.
 *
 * Do as much as you can by the deadline, but however submit whatever you have got by the deadline.
 * I don’t expect you to design a complete drawing application, just do as much as you can before the deadline.
 *
 * Hints: The easiest sharps are lines and circles.
 * For lines, you only need decide a starting position and an ending position.
 * For circles, you need to decide the circle center point and its radius.
 * Please try to draw the sharp first then move on to increase the functionality by adding the thickness and
 * color of the sharp, etc.
 *
 * Created by myltik
 * Created on 8/23/13 5:38 PM
 */
public class W08A1App implements Runnable {

    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;

    public W08A1App() {
    }

    /**
     * Render GUI
     */
    @Override
    public void run() {
        render();
    }

    /**
     * Ask user for input. Also display evaluation result.
     */
    private void render() {
        JFrame frame = new JFrame("Paint Tool");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final DrawTool mainPane = new DrawTool(WIDTH, HEIGHT);
        frame.add(mainPane);
        frame.setJMenuBar(new DrawToolMenu(mainPane, mainPane));
        frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        frame.pack();
        frame.setResizable(true);
        frame.setVisible(true);
    }
}
