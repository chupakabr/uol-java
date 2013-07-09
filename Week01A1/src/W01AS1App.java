import javax.swing.*;

/**
 * Created by myltik
 * Created on 7/9/13 1:50 PM
 */
public class W01AS1App {

    private String username = null;
    private Integer age = null;

    /**
     * App business logic
     */
    void run() {
        try {
            displayWelcomeMessage();
            askUsername();
            askAge();
            displaySummaryMessage();
            displayGuessWhatMessage();
        } catch (CloseAppException e) {
            displayAbnormalExitMessage(e.getMessage());
        }
    }

    /**
     * Display welcome message to the user
     */
    private void displayWelcomeMessage() {
        JOptionPane.showMessageDialog(
                null,
                "Welcome to my program!",
                "Welcome!",
                JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Ask user for his/her full name
     */
    private void askUsername() throws CloseAppException {
        String name;
        username = null;

        while (username == null) {
            name = JOptionPane.showInputDialog(
                    null,
                    "Please enter your name:",
                    "Name?",
                    JOptionPane.QUESTION_MESSAGE);

            if (name == null) {
                throw new CloseAppException("No name has been provided");
            }

            name = name.trim();
            if (name.length() > 0) {
                username = name;
            }
        }
    }

    /**
     * Ask user for his/her age
     */
    private void askAge() throws CloseAppException {
        String ageStr;
        age = null;

        while (age == null) {
            ageStr = JOptionPane.showInputDialog(
                    null,
                    "Please enter your age:",
                    "Age?",
                    JOptionPane.QUESTION_MESSAGE);

            if (ageStr == null) {
                throw new CloseAppException("No age has been provided");
            }

            try {
                age = Integer.valueOf(ageStr);
            } catch (NumberFormatException e) {
                // ignore
            }
        }
    }

    /**
     * Tell user his/her name and age
     */
    private void displaySummaryMessage() {
        JOptionPane.showMessageDialog(
                null,
                username + ", you are " + age + " years old!",
                "Summary",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Tell user how old he/she will be in 10 years
     */
    private void displayGuessWhatMessage() {
        JOptionPane.showMessageDialog(
                null,
                "In 10 years, you will be " + (age+10) + " years old!",
                "Guess What?",
                JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Display abronmal message to the user
     * @param message Warning message to display
     */
    private void displayAbnormalExitMessage(String message) {
        JOptionPane.showMessageDialog(
                null,
                "Not enough information: " + message + ". Exiting application.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }
}
