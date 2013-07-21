import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Double pair input fields container.
 */
public class DoublePairInputPanel extends JPanel {

    protected final JLabel statusLabel;
    protected final JTextField firstValueField;
    protected final JTextField secondValueField;

    public DoublePairInputPanel() {
        super(new BorderLayout());

        //
        // Information message

        this.add(new JLabel("Please input values for pair of doubles"), BorderLayout.NORTH);


        //
        // Input fields

        final Border inputNameBorder = BorderFactory.createEmptyBorder(5, 0, 5, 0);

        final JLabel widthLabel = new JLabel("First value:");
        widthLabel.setBorder(inputNameBorder);

        final JLabel lengthLabel = new JLabel("Second value:");
        lengthLabel.setBorder(inputNameBorder);

        final JPanel inputNamesContainer = new JPanel();
        inputNamesContainer.setLayout(new BoxLayout(inputNamesContainer, BoxLayout.Y_AXIS));
        inputNamesContainer.add(widthLabel);
        inputNamesContainer.add(lengthLabel);

        JPanel inputFieldsContainer = new JPanel();
        inputFieldsContainer.setLayout(new BoxLayout(inputFieldsContainer, BoxLayout.Y_AXIS));
        firstValueField = new JTextField(15);
        secondValueField = new JTextField(15);
        inputFieldsContainer.add(firstValueField);
        inputFieldsContainer.add(secondValueField);

        final JPanel inputContainer = new JPanel(new FlowLayout());
        inputContainer.add(inputNamesContainer);
        inputContainer.add(inputFieldsContainer);

        this.add(inputContainer, BorderLayout.WEST);


        //
        // Status label to display error message if needed

        statusLabel = new JLabel("");
        statusLabel.setForeground(Color.RED);
        this.add(statusLabel, BorderLayout.SOUTH);
    }

    /**
     * Validate all input fields, display error in case of invalid value(s)
     * @return true if all values are valid, false otherwise
     */
    public boolean isValidValues() {
        try {
            getFirstValue();
        } catch (NumberFormatException e) {
            statusLabel.setText("Invalid value of [first] property, should be valid double value");
            return false;
        }

        try {
            getSecondValue();
        } catch (NumberFormatException e) {
            statusLabel.setText("Invalid value of [second] property, should be valid double value");
            return false;
        }

        return true;
    }

    /**
     * @return First value
     */
    public double getFirstValue() {
        return getDoubleInputValue(firstValueField);
    }

    /**
     * @return Second value
     */
    public double getSecondValue() {
        return getDoubleInputValue(secondValueField);
    }

    /**
     * @param inputField Input field holding the value
     * @return Double value parsed from specified input field
     */
    private double getDoubleInputValue(JTextField inputField) {
        return Double.valueOf(inputField.getText()).doubleValue();
    }
}
