import javax.swing.*;

/**
 * Created by myltik
 * Created on 7/5/13 4:54 PM
 */
public class W01A1App {

    /**
     * Do business logic: Run four JDialogs in a row to ask and display user's name and birthday.
     */
    void run() {
        String username = null, birthday = null;
        Object[] onlyOkButton = {"OK"};

        try {

            //
            // Step 1: First, display a welcome message to your user in one JOptionPane when the application starts.
            // Example of usage of JOptionPane directly without using one of its helpers.

            JOptionPane pane = new JOptionPane(
                    "Welcome to my first Java app!",
                    JOptionPane.PLAIN_MESSAGE,
                    JOptionPane.DEFAULT_OPTION);
            JDialog dlg = pane.createDialog("Welcome");
            dlg.setVisible(true);
            dlg.dispose();


            //
            // Step 2: Second, when the user closes the first JOptionPane, use another one to ask the user for his or her name.
            // We do not validate user's input here as he might have no keyboard so he won't be able to input any word :)

            username = JOptionPane.showInputDialog(
                    null,
                    "Tell me please, what is your name?",
                    "Input your name",
                    JOptionPane.QUESTION_MESSAGE);

            log("Username: " + username);

            if (username == null) {
                return;
            }


            //
            // Step 3: Third, use another JOptionPane to ask the user for his or her birth date.

            JTextField dayField = new JTextField("1", 2);
            JTextField monthField = new JTextField("1", 2);
            JTextField yearField = new JTextField("1980", 4);

            JPanel panel = new JPanel();
            panel.add(dayField);
            panel.add(new JLabel("/"));
            panel.add(monthField);
            panel.add(new JLabel("/"));
            panel.add(yearField);

            // For simplicity don't do any validation here
            JOptionPane.showOptionDialog(
                    null,
                    panel,
                    "Input your birthday",
                    JOptionPane.INFORMATION_MESSAGE,
                    JOptionPane.OK_CANCEL_OPTION,
                    null,
                    onlyOkButton,
                    onlyOkButton[0]);

            StringBuilder sb = new StringBuilder();
            sb.append(dayField.getText())
              .append("/")
              .append(monthField.getText())
              .append("/")
              .append(yearField.getText());
            birthday = sb.toString();

            log("Birthday: " + birthday);

        } finally {
            // Step 4: Finally, use a fourth JOptionPane to display the user’s name and birth date and thank them for using your program.
            if (username == null) {
                JOptionPane.showOptionDialog(
                        null,
                        "Thanks for using our app! Unfortunately you didn't provide your name. Please press OK button next time :)",
                        "Thanks!",
                        JOptionPane.INFORMATION_MESSAGE,
                        JOptionPane.OK_CANCEL_OPTION,
                        null,
                        onlyOkButton,
                        onlyOkButton[0]);
            } else {
                JOptionPane.showOptionDialog(
                        null,
                        "Thanks for using our app, " + username + ". Your birthday is: " + birthday + ".",
                        "Thanks!",
                        JOptionPane.PLAIN_MESSAGE,
                        JOptionPane.OK_CANCEL_OPTION,
                        null,
                        onlyOkButton,
                        onlyOkButton[0]);
            }
        }
    }

    /**
     * Print debug message into stdout.
     * @param msg Message to print
     */
    private void log(String msg) {
        System.out.print(msg);
    }
}
