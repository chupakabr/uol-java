import javax.swing.*;

/**
 * Created by myltik
 * Created on 7/10/13 2:11 PM
 */
public class W02DQ1App {

    private Integer distanceInMeters = null;

    /**
     * Write a program that uses JOptionPanes to perform the following steps:
     * Given a distance in metres, outputs that distance in kilometres rounded to the nearest whole kilometre.
     * For example, given 1100m the output will be 1km, and given 1900m the output will be 2km.
     */
    public void run() {
        try {
            while (true) {
                askDistance();
                displayResult();
            }
        } catch (CloseAppException e) {
            // do nothing, just exit app
        }
    }

    /**
     * Ask user to input a distance in meters
     * @throws CloseAppException
     */
    private void askDistance() throws CloseAppException{
        String distanceStr;
        distanceInMeters = null;

        while (distanceInMeters == null) {
            distanceStr = JOptionPane.showInputDialog(
                    null,
                    "Please input distance in meters:",
                    "Distance in meters?",
                    JOptionPane.QUESTION_MESSAGE
            );

            // Check whether cancel button has been clicked, exit app
            if (distanceStr == null) {
                throw new CloseAppException();
            }

            // Validate input for an integer
            try {
                distanceInMeters = Integer.valueOf(distanceStr);
            } catch (NumberFormatException e) {
                // ignore, just render input dialog again
            }
        }
    }

    /**
     * Display a distance in kilometers
     */
    private void displayResult() {
        JOptionPane.showMessageDialog(
                null,
                "Distance: " + distanceInMeters + " meters is about " + convertMetersToKm(distanceInMeters) + " km",
                "Conversion result",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Convert meters to kilometers rounding to the nearest bound
     * @param meters
     * @return Kilometers
     */
    private int convertMetersToKm(Integer meters) {
        if (meters == null) return 0;
        return Math.round(meters.intValue() / 1000f);
    }
}
