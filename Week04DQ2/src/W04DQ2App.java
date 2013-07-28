import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/**
 * Created by myltik
 * Created on 7/26/13 4:40 PM
 */
public class W04DQ2App implements Runnable {

    private static final Color ERROR_COLOR = Color.RED;
    private static final Color OK_COLOR = Color.BLACK;

    private final DecimalFormat numberFormatter;

    private final JButton evaluateButton;
    private final JLabel origLabel;
    private final JLabel resultLabel;
    private final JTextField origTextField;
    private final JTextField resultTextField;

    public W04DQ2App() {
        evaluateButton = new JButton("Get square");
        evaluateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                powerNumber();
            }
        });

        origLabel = new JLabel("Number:");
        resultLabel = new JLabel("Square:");

        origTextField = new JTextField(14);
        resultTextField = new JTextField(14);
        resultTextField.setEditable(false);

        numberFormatter = new DecimalFormat("#.#######");
    }

    /**
     * Write and run a Java program which allows the user to input a double and outputs the square of this number.
     */
    @Override
    public void run() {
        render();
    }

    /**
     * Ask user for input. Also display evaluation result.
     */
    private void render() {
        JFrame frame = new JFrame("Square Number");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pane = new JPanel();
        pane.setLayout(new FlowLayout());

        pane.add(origLabel);
        pane.add(origTextField);
        pane.add(resultLabel);
        pane.add(resultTextField);
        pane.add(evaluateButton);

        frame.add(pane);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    /**
     * Get square of specified number, also updates result text field with result value or error
     */
    private void powerNumber() {
        double number;
        try {
            number = Double.valueOf(origTextField.getText());

            resultTextField.setForeground(OK_COLOR);
            resultTextField.setText("" + numberFormatter.format(Math.pow(number, 2)));
        } catch (NumberFormatException e) {
            resultTextField.setForeground(ERROR_COLOR);
            resultTextField.setText("Invalid number provided");
        }
    }
}
