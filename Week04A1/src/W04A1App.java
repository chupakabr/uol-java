import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/**
 * Produce a computer program, written in Java, which determines the distance travelled by a projectile
 * (launched from the ground) given:
 * 1.  The velocity at launch (u), and
 * 2.  The launch angle (angle of elevation) above the horizontal (A).
 *
 * Assume the following:
 * 1.  The angle of elevation is given in degrees and is in the range of 0 to 90.
 * 2.  Start velocity is given as a positive number.
 * 3.  Gravity (g) is equivalent to 10m/s ^ 2.
 * 4.  Ignore air resistance.
 *
 * Note also that to solve the above we must carry out the following steps:
 * 1.  Calculate the vertical and horizontal components of u (the launch velocity) using the following trigonometric identities:
 *   Vertical component of launch velocity  (Vu) = u x sinA
 *   Horizontal component of launch velocity (Hu) = u x cosA
 * 2.  Calculate the time (t) taken for the body to return to the ground using the identity:
 *   t = (2 x Vu) / a
 *   where a (deceleration due to gravity) is equivalent to g (10m/s ^ 2 in this case).
 * 3.  Calculate distance (s) travelled from the identity:
 *   s = Hu x t
 *
 * EXAMPLE:
 * A body is projected with a velocity of u = 200 m/s at an angle of elevation A = 30 degrees above the horizontal.
 * Determine the distance travelled by the projectile.
 * Vu  = 200 x sin30 = 100 (m/s)
 * Hu = 200 x cos30 = 173.2 (m/s)
 * t = {2 x 100) / 10 = 20 (s)
 * s = 20 x 173.2051 = 3464.1 (m)
 *
 * Created by myltik
 * Created on 7/30/13 7:40 PM
 */
public class W04A1App implements Runnable {

    private static final Color ERROR_COLOR = Color.RED;
    private static final Color RESULT_COLOR = Color.BLUE;

    private final DecimalFormat numberFormatter;

    private final JLabel velocityLabel;
    private final JLabel angleLabel;
    private final JTextField velocityTextField;
    private final JTextField angleTextField;
    private final JButton calculateButton;
    private final JLabel resultLabel;

    private final NatureEnvironment environment;

    public W04A1App() {
        this(new EarthEnvironment());
    }

    public W04A1App(NatureEnvironment environment) {
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                calculateAndUpdateUI();
            }
        });

        velocityLabel = new JLabel("Projectile velocity:");
        angleLabel = new JLabel("Launch angle:");
        resultLabel = new JLabel();

        velocityTextField = new JTextField(10);
        angleTextField = new JTextField(7);

        numberFormatter = new DecimalFormat("#.#####");

        this.environment = environment;
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
        JFrame frame = new JFrame("Projectile Launcher");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel actionsPane = new JPanel(new FlowLayout());
        actionsPane.add(velocityLabel);
        actionsPane.add(velocityTextField);
        actionsPane.add(angleLabel);
        actionsPane.add(angleTextField);

        JPanel resultsPane = new JPanel(new FlowLayout());
        resultsPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
        resultsPane.add(calculateButton);
        resultsPane.add(resultLabel);

        JPanel mainPane = new JPanel(new BorderLayout());
        mainPane.add(actionsPane, BorderLayout.NORTH);
        mainPane.add(resultsPane, BorderLayout.WEST);

        frame.add(mainPane);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    /**
     * Get square of specified number, also updates result text field with result value or error
     */
    private void calculateAndUpdateUI() {
        try {
            final Projectile projectile = new Projectile(getNumberFromText(
                    velocityTextField.getText(),
                    "Invalid velocity, should be positive"));

            final Angle angle = new Angle(getNumberFromText(
                    angleTextField.getText(),
                    "Invalid angle, should be in range from " + Angle.MIN_VALUE + " to " + Angle.MAX_VALUE));

            final Launcher launcher = new Launcher(projectile, angle, environment);

            resultLabel.setForeground(RESULT_COLOR);
            resultLabel.setText("Travelled distance is "
                    + numberFormatter.format(launcher.getTravelledDistance()) + " meters");
        } catch (NumberFormatException e) {
            resultLabel.setForeground(ERROR_COLOR);
            resultLabel.setText(e.getMessage());
        }
    }

    /**
     * @param text
     * @param errorText
     * @return Number
     * @throws NumberFormatException
     */
    private double getNumberFromText(String text, String errorText) throws NumberFormatException {
        try {
            return Double.valueOf(text);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(errorText);
        }
    }
}
