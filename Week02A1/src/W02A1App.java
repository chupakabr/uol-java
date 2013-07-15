import javax.swing.*;
import java.text.DecimalFormat;

/**
 * Created by myltik
 * Created on 7/15/13 1:39 PM
 */
public class W02A1App {

    private static final Object[] askViewButtons = new String[] {"Proceed", "Exit"};
    private SwimmingPool swimmingPool = null;

    /**
     * Write a program that uses JOptionPanes to perform the following steps:
     * Given a distance in metres, outputs that distance in kilometres rounded to the nearest whole kilometre.
     * For example, given 1100m the output will be 1km, and given 1900m the output will be 2km.
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
     * Ask user to input swimming pool's width, length and depth in meters
     * @throws CloseAppException
     */
    private void askValues() throws CloseAppException{
        final SwimmingPoolCharacteristicsPanel container = new SwimmingPoolCharacteristicsPanel();
        swimmingPool = null;

        // Validate input values, display error message if needed
        while (swimmingPool == null) {
            int result = JOptionPane.showOptionDialog(
                    null,
                    container,
                    "Define Swimming Pool",
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

            // Create swimming pool instance if valid characteristics had been provided by the user,
            // container will display error message in case of validation error
            if (container.isValidValues()) {
                swimmingPool = new SwimmingPool(
                        container.getWidthValue(),
                        container.getLengthValue(),
                        container.getDepthValue());
            }
        }
    }

    /**
     * Display a distance in kilometers
     */
    private void displayResult() {
        assert swimmingPool != null;

        final DecimalFormat numberFormatter = new DecimalFormat("#.##");

        JOptionPane.showMessageDialog(
                null,
                "<html><h3>Swimming pool information</h3><ul>" +
                        "<li>Width is " + numberFormatter.format(swimmingPool.getWidth()) + " meters" +
                        "<li>Length is " + numberFormatter.format(swimmingPool.getLength()) + " meters" +
                        "<li>Depth is " + numberFormatter.format(swimmingPool.getDepth()) + " meters" +
                        "<li><b>Volume</b> is " + numberFormatter.format(swimmingPool.getVolume()) + " liters" +
                        "<li><b>Filling time</b> is " + numberFormatter.format(swimmingPool.getFillingHours()) + " hours" +
                        "</ul></html>",
                "Swimming Pool Information",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
