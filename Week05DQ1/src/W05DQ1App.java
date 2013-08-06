import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 1. Implement a class called ShortAddress that has the following attributes: firstName, secondName, and phoneNumber.
 *
 * 2. Now implement a class called FullAddress that inherits the above attributes while adding the attributes (int)
 * houseNumber (simply 1, 2, … etc. - i.e. no 1a or 3b's allowed), street1Name, street2Name and cityName.
 * Don’t forget to use the keyword super in the constructor.
 *
 * 3. Finally write an application class to allow the user to input an address details and then give the user the
 * choice of viewing the short address details or the long address details. This means your final answer should have
 * a minimum of 3 classes for the application - you may use more if you are including utility classes.
 *
 * 4. Use exception handling to make the program robust.
 *
 * Created by myltik
 * Created on 8/1/13 7:40 PM
 */
public class W05DQ1App implements Runnable, ActionListener {

    private final InputFieldsJPanel mainPane;
    private final DataRenderer<PersonContacts> dataRenderer;

    public W05DQ1App() {
        mainPane = new InputFieldsJPanel(this);
        dataRenderer = new AddressRenderer();
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
        JFrame frame = new JFrame("Addresses");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setMinimumSize(mainPane.getRealDimensions());

        frame.setContentPane(mainPane);
        frame.pack();
        frame.setResizable(true);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if ("Reset".equals(actionEvent.getActionCommand())) {
            mainPane.reset();
        } else {
            try {
                PersonContacts contacts;
                if ("Short Address".equals(actionEvent.getActionCommand())) {
                    contacts = mainPane.getShortContacts();
                } else {
                    contacts = mainPane.getFullContacts();
                }

                JOptionPane.showMessageDialog(
                        null,
                        dataRenderer.render(contacts),
                        "Address",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (InputValidationException e) {
                // do nothing, error will be displayed by mainPane itself
            }
        }
    }
}
