import javax.swing.*;
import java.text.DecimalFormat;

/**
 * Created by myltik
 * Created on 7/22/13 5:29 PM
 */
public class W03A1App {

    private static final Object[] askViewButtons = new String[] {"Proceed", "Exit"};
    private Triangle triangle = null;

    /**
     * Using JOptionPanes to handle your input and output, produce a Java program which, given three sides of
     * a triangle, determines whether the triangle is:
     * 1.  Equilateral - all sides the same second,
     * 2.  Isosceles - two sides the same second or
     * 3.  Scalene - no sides the same second.
     * Assume that any individual side must be a positive number not greater than 100.0.
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
     * Ask user to input triangle sides
     * @throws CloseAppException
     */
    private void askValues() throws CloseAppException{
        final TriangleCharacteristicsPanel container = new TriangleCharacteristicsPanel();
        triangle = null;

        // Validate input values, display error message if needed
        while (triangle == null) {
            int result = JOptionPane.showOptionDialog(
                    null,
                    container,
                    "Define Triangle",
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

            // Validate input values
            if (container.isValidValues()) {
                triangle = new Triangle(
                        container.getFirstSideValue(),
                        container.getSecondSideValue(),
                        container.getThirdSideValue());
            }
        }
    }

    /**
     * Display a triangle sides and type
     */
    private void displayResult() {
        assert triangle != null;

        final DecimalFormat numberFormatter = new DecimalFormat("#.###");

        JOptionPane.showMessageDialog(
                null,
                "<html><h3>Triangle information</h3><ul>" +
                        "<li>First side length is " + numberFormatter.format(triangle.getFirst()) +
                        "<li>Second side length is " + numberFormatter.format(triangle.getSecond()) +
                        "<li>Third side length is " + numberFormatter.format(triangle.getThird()) +
                        "<li><b>Triangle type is " + triangle.getType() + "</b>" +
                        "</ul></html>",
                "Triangle Information",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
