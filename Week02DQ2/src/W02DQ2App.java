import javax.swing.*;

/**
 * Created by myltik
 * Created on 7/10/13 2:15 PM
 */
public class W02DQ2App {

    private Float distance = null;
    private Float time = null;

    /**
     * Write a program that uses JOptionPanes to perform the following steps:
     * Given the distance and time traveled, outputs the average speed.
     *   speed = distance/time
     * For example, if the distance of travel is 30 kilometers, the time of travel is 2 hours,
     * then the speed is 30/2 = 15 (kilometers per hour).
     */
    public void run() {
        try {
            while (true) {
                askDistance();
                askTime();
                displayResult();
            }
        } catch (CloseAppException e) {
            // do nothing, just exit app
        }
    }

    /**
     * Ask user to input a distance in kilometers.
     * Float values allowed, for example: 100.5, 50.55.
     * @throws CloseAppException
     */
    private void askDistance() throws CloseAppException {
        distance = showFloatInput("Distance?", "Please input traveled distance in kilometers:");
    }

    /**
     * Ask user to input a time in hours.
     * Float value allowed, for example: 10.5, 20.25.
     * @throws CloseAppException
     */
    private void askTime() throws CloseAppException {
        time = showFloatInput("Time?", "Please input traveled time in hours:");
    }

    /**
     * Ask user to input some float value.
     * @param title Popup title
     * @param text Input field description
     * @throws CloseAppException
     */
    private Float showFloatInput(String title, String text) throws CloseAppException {
        String inputStr;
        Float val  = null;

        while (val == null) {
            inputStr = JOptionPane.showInputDialog(null, text, title, JOptionPane.QUESTION_MESSAGE);

            // Check whether cancel button has been clicked, exit app
            if (inputStr == null) {
                throw new CloseAppException();
            }

            // Validate input for an integer
            try {
                val = Float.valueOf(inputStr);
            } catch (NumberFormatException e) {
                // ignore, just render input dialog again
            }
        }

        return val;
    }

    /**
     * Display a distance in kilometers
     */
    private void displayResult() {
        JOptionPane.showMessageDialog(
                null,
                String.format("Distance = %.2f km, time = %.2f hours, average speed = %.2f km/h",
                        distance,
                        time,
                        calculateAverageSpeed(distance, time)),
                "Conversion result",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Calculate average speed using given distance and time.
     * Formula: distance / time
     * @param distance
     * @param time
     * @return Average speed
     */
    private float calculateAverageSpeed(Float distance, Float time) {
        if (distance == null || time == null) return 0f;
        return distance / time;
    }
}
