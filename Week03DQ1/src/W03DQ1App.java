import javax.swing.*;
import java.text.DecimalFormat;

/**
 * Created by myltik
 * Created on 7/21/13 8:47 PM
 */
public class W03DQ1App {

    private static final Object[] askViewButtons = new String[] {"Proceed", "Exit"};
    private DoublePair numericPair = null;

    /**
     * Write and run a Java program which allows the user to input two doubles and outputs the greatest of the two.
     */
    public void run() {
        try {
            while (true) {
                askValues();
                displayResult();
            }
        } catch (CloseAppException e) {
            // do nothing, just exit app
        }
    }

    /**
     * Ask user to input pair of double values
     * @throws CloseAppException
     */
    private void askValues() throws CloseAppException {
        final DoublePairInputPanel container = new DoublePairInputPanel();
        numericPair = null;

        // Validate input values, display error message if needed
        while (numericPair == null) {
            int result = JOptionPane.showOptionDialog(
                    null,
                    container,
                    "Specify two double numbers",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    askViewButtons,
                    askViewButtons[0]
            );

            // Check whether cancel button has been clicked, exit app
            if (result == 1 || result == JOptionPane.CLOSED_OPTION) {
                throw new CloseAppException();
            }

            // Validate values
            if (container.isValidValues()) {
                numericPair = new DoublePair(container.getFirstValue(), container.getSecondValue());
            }
        }
    }

    /**
     * Display result, i.e. greatest value of two
     */
    private void displayResult() {
        assert numericPair != null;

        final DecimalFormat numberFormatter = new DecimalFormat("#.########");

        JOptionPane.showMessageDialog(
                null,
                "<html><h3>Processing summary:</h3><ul>" +
                        "<li>First value is " + numberFormatter.format(numericPair.getFirst()) +
                        "<li>Second value is " + numberFormatter.format(numericPair.getSecond()) +
                        "<li><b>Greater</b> value is <b>" + numberFormatter.format(numericPair.greatest()) + "</b>" +
                        "</ul></html>",
                "Processing Summary",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
