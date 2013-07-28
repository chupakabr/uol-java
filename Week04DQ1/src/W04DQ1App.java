import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/**
 * Created by myltik
 * Created on 7/26/13 4:40 PM
 */
public class W04DQ1App implements Runnable {

    private static final float CONVERSION_RATE = 1.91f;

    private static final Color ERROR_COLOR = Color.RED;
    private static final Color OK_COLOR = Color.BLACK;

    private final DecimalFormat numberFormatter;

    private final JButton convertButton;
    private final JLabel usdLabel;
    private final JLabel gbpLabel;
    private final JTextField usdTextField;
    private final JTextField gbpTextField;

    public W04DQ1App() {
        convertButton = new JButton("Convert");
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                convertCurrency();
            }
        });

        usdLabel = new JLabel("USD:");
        gbpLabel = new JLabel("GBP:");

        usdTextField = new JTextField(12);
        gbpTextField = new JTextField(12);
        gbpTextField.setEditable(false);

        numberFormatter = new DecimalFormat("#.##");
    }

    /**
     * Please design a currency conversion program, to allow users to enter a double in US dollar,
     * outputs the equitant in GB sterling (rate at 1 GB sterm = 1.91 US dollar)
     */
    @Override
    public void run() {
        render();
    }

    /**
     * Ask user for input. Also display conversion result.
     */
    private void render() {
        JFrame frame = new JFrame("Currency Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pane = new JPanel();
        pane.setLayout(new FlowLayout());

        pane.add(usdLabel);
        pane.add(usdTextField);
        pane.add(gbpLabel);
        pane.add(gbpTextField);
        pane.add(convertButton);

        frame.add(pane);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    /**
     * Currency conversion business logic, also updates GBP text field with GBP value or error
     */
    private void convertCurrency() {
        float usd;
        try {
            usd = Float.valueOf(usdTextField.getText());
            if (usd < 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            gbpTextField.setForeground(ERROR_COLOR);
            gbpTextField.setText("Invalid USD value");
            return;
        }

        gbpTextField.setForeground(OK_COLOR);
        gbpTextField.setText("" + numberFormatter.format(usd / CONVERSION_RATE));
    }
}
