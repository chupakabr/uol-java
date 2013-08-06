import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by myltik
 * Created on 8/1/13 8:56 PM
 */
public class InputFieldsJPanel extends JPanel {

    private static final Color ERROR_COLOR = Color.RED;

    private final JLabel firstNameLabel;
    private final JTextField firstNameTextField;

    private final JLabel lastNameLabel;
    private final JTextField lastNameTextField;

    private final JLabel phoneLabel;
    private final JTextField phoneTextField;

    private final JLabel cityLabel;
    private final JTextField cityTextField;

    private final JLabel houseNumberLabel;
    private final JTextField houseNumberTextField;

    private final JLabel street1Label;
    private final JTextField street1TextField;

    private final JLabel street2Label;
    private final JTextField street2TextField;

    private final JButton shortAddrButton;
    private final JButton fullAddrButton;
    private final JButton resetButton;

    private final JLabel errorsLabel;

    public InputFieldsJPanel(ActionListener mediator) {
        super(new SpringLayout());

        firstNameLabel = new JLabel("First name:");
        firstNameTextField = new JTextField(15);

        lastNameLabel = new JLabel("Last name:");
        lastNameTextField = new JTextField(15);

        phoneLabel= new JLabel("Phone number:");
        phoneTextField = new JTextField(15);

        cityLabel = new JLabel("City:");
        cityTextField = new JTextField(20);

        houseNumberLabel = new JLabel("House number:");
        houseNumberTextField = new JTextField(5);

        street1Label = new JLabel("Street 1:");
        street1TextField = new JTextField(20);

        street2Label = new JLabel("Street 2:");
        street2TextField = new JTextField(20);

        errorsLabel = new JLabel("");
        errorsLabel.setForeground(ERROR_COLOR);

        shortAddrButton = new JButton("Short Address");
        shortAddrButton.addActionListener(mediator);

        fullAddrButton = new JButton("Full Address");
        fullAddrButton.addActionListener(mediator);

        resetButton = new JButton("Reset");
        resetButton.addActionListener(mediator);

        bindComponents();
        alignComponents();
    }

    /**
     * Add each components to the pane
     */
    private void bindComponents() {
        add(firstNameLabel);
        add(firstNameTextField);
        add(lastNameLabel);
        add(lastNameTextField);
        add(phoneLabel);
        add(phoneTextField);
        add(cityLabel);
        add(cityTextField);
        add(houseNumberLabel);
        add(houseNumberTextField);
        add(street1Label);
        add(street1TextField);
        add(street2Label);
        add(street2TextField);
        add(street2TextField);
        add(shortAddrButton);
        add(fullAddrButton);
        add(resetButton);
        add(errorsLabel);
    }

    /**
     * Align each component within the pane. SpringLayout.
     */
    private void alignComponents() {
        SpringLayout layout = (SpringLayout) getLayout();

        layout.putConstraint(SpringLayout.WEST, firstNameLabel, 5, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, firstNameLabel, 10, SpringLayout.NORTH, this);

        layout.putConstraint(SpringLayout.WEST, firstNameTextField, 40, SpringLayout.EAST, firstNameLabel);
        layout.putConstraint(SpringLayout.NORTH, firstNameTextField, 5, SpringLayout.NORTH, this);

        alignGroup(lastNameLabel, lastNameTextField, firstNameTextField);
        alignGroup(phoneLabel, phoneTextField, lastNameTextField);
        alignGroup(cityLabel, cityTextField, phoneTextField);
        alignGroup(houseNumberLabel, houseNumberTextField, cityTextField);
        alignGroup(street1Label, street1TextField, houseNumberTextField);
        alignGroup(street2Label, street2TextField, street1TextField);

        layout.putConstraint(SpringLayout.WEST, shortAddrButton, 5, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, shortAddrButton, 5, SpringLayout.SOUTH, street2TextField);

        layout.putConstraint(SpringLayout.WEST, fullAddrButton, 5, SpringLayout.EAST, shortAddrButton);
        layout.putConstraint(SpringLayout.NORTH, fullAddrButton, 0, SpringLayout.NORTH, shortAddrButton);

        layout.putConstraint(SpringLayout.WEST, resetButton, 5, SpringLayout.EAST, fullAddrButton);
        layout.putConstraint(SpringLayout.NORTH, resetButton, 0, SpringLayout.NORTH, fullAddrButton);

        layout.putConstraint(SpringLayout.WEST, errorsLabel, 5, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, errorsLabel, 5, SpringLayout.SOUTH, shortAddrButton);
    }

    /**
     * Align group of components relative to specified component.
     * Use it to align pair of JLabel and JTextField.
     * @param c1
     * @param c2
     * @param relativeTo
     */
    private void alignGroup(JComponent c1, JComponent c2, JComponent relativeTo) {
        SpringLayout layout = (SpringLayout) getLayout();

        layout.putConstraint(SpringLayout.WEST, c1, 5, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, c1, 10, SpringLayout.SOUTH, relativeTo);

        layout.putConstraint(SpringLayout.WEST, c2, 0, SpringLayout.WEST, firstNameTextField);
        layout.putConstraint(SpringLayout.NORTH, c2, 5, SpringLayout.SOUTH, relativeTo);
    }

    /**
     * Reset all input fields and error messages
     */
    public void reset() {
        firstNameTextField.setText("");
        lastNameTextField.setText("");
        phoneTextField.setText("");
        cityTextField.setText("");
        houseNumberTextField.setText("");
        street1TextField.setText("");
        street2TextField.setText("");
        errorsLabel.setText("");
    }

    /**
     * @return Pane dimensions (width and height)
     */
    public Dimension getRealDimensions() {
        // TODO Real values
        return new Dimension(380, 320);
    }

    /**
     * @return Short address
     * @throws InputValidationException
     */
    public PersonContacts getShortContacts() throws InputValidationException {
        validateInputFields(false);

        return new ShortAddress(
                firstNameTextField.getText(),
                lastNameTextField.getText(),
                phoneTextField.getText());
    }

    /**
     * @return Full address
     * @throws InputValidationException
     */
    public PersonContacts getFullContacts() throws InputValidationException {
        validateInputFields(true);

        return new FullAddress(
                firstNameTextField.getText(),
                lastNameTextField.getText(),
                phoneTextField.getText(),
                Integer.parseInt(houseNumberTextField.getText()),
                street1TextField.getText(),
                street2TextField.getText(),
                cityTextField.getText());
    }

    /**
     * Validate input fields
     * @param extended Whether to check extra fields which are needed for full addrees
     * @throws InputValidationException
     */
    private void validateInputFields(final boolean extended) throws InputValidationException {
        try {
            if (isTextFieldEmpty(firstNameTextField)) throw new InputValidationException("First name must be set");
            if (isTextFieldEmpty(lastNameTextField)) throw new InputValidationException("Last name must be set");
            if (isTextFieldEmpty(phoneTextField)) throw new InputValidationException("Phone number must be set");

            if (extended) {
                if (isTextFieldEmpty(houseNumberTextField)) throw new InputValidationException("House number must be set");
                try {
                    Integer.parseInt(houseNumberTextField.getText());
                } catch (NumberFormatException e) {
                    throw new InputValidationException("House number must be positive number");
                }

                if (isTextFieldEmpty(street1TextField)) throw new InputValidationException("Street 1 name must be set");
                if (isTextFieldEmpty(cityTextField)) throw new InputValidationException("City must be set");
            }

            errorsLabel.setText("");
        } catch (InputValidationException e) {
            errorsLabel.setText(e.getMessage());
            throw e; //rethrow
        }
    }

    /**
     * @param textField
     * @return true is specified text field is empty (null or nothing has been entered), false otherwise
     */
    private boolean isTextFieldEmpty(JTextField textField) {
        if (textField == null) {
            return true;
        }

        String data = textField.getText();
        return (data == null || "".equals(data));
    }
}
