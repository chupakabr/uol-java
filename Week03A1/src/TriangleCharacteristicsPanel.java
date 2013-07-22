import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 *
 * Triangle characteristics input fields container.
 * Used to ask a user to input triangle characteristics which are three sides.
 *
 * Created by myltik
 * Created on 7/22/13 5:57 PM
 */
public class TriangleCharacteristicsPanel extends JPanel {

    protected final JLabel statusLabel;
    protected final JTextField firstSideField;
    protected final JTextField secondSideField;
    protected final JTextField thirdSideField;

    public TriangleCharacteristicsPanel() {
        super(new BorderLayout());

        //
        // Information message

        this.add(new JLabel("Please input triangle sides"), BorderLayout.NORTH);


        //
        // Input fields

        final Border inputNameBorder = BorderFactory.createEmptyBorder(5, 0, 5, 0);

        final JLabel firstSideLabel = new JLabel("First side:");
        firstSideLabel.setBorder(inputNameBorder);

        final JLabel secondSideLabel = new JLabel("Second side:");
        secondSideLabel.setBorder(inputNameBorder);

        final JLabel thirdSideLabel = new JLabel("Third side:");
        thirdSideLabel.setBorder(inputNameBorder);

        final JPanel inputNamesContainer = new JPanel();
        inputNamesContainer.setLayout(new BoxLayout(inputNamesContainer, BoxLayout.Y_AXIS));
        inputNamesContainer.add(firstSideLabel);
        inputNamesContainer.add(secondSideLabel);
        inputNamesContainer.add(thirdSideLabel);

        JPanel inputFieldsContainer = new JPanel();
        inputFieldsContainer.setLayout(new BoxLayout(inputFieldsContainer, BoxLayout.Y_AXIS));
        firstSideField = new JTextField(10);
        secondSideField = new JTextField(10);
        thirdSideField = new JTextField(10);
        inputFieldsContainer.add(firstSideField);
        inputFieldsContainer.add(secondSideField);
        inputFieldsContainer.add(thirdSideField);

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
            getFirstSideValue();
        } catch (NumberFormatException e) {
            statusLabel.setText("Invalid value of [first side] property: " + e.getMessage());
            return false;
        }

        try {
            getSecondSideValue();
        } catch (NumberFormatException e) {
            statusLabel.setText("Invalid value of [second side] property: " + e.getMessage());
            return false;
        }

        try {
            getThirdSideValue();
        } catch (NumberFormatException e) {
            statusLabel.setText("Invalid value of [third side] property: " + e.getMessage());
            return false;
        }

        return true;
    }

    /**
     * @return First side value
     */
    public float getFirstSideValue() {
        return getFloatInputValue(firstSideField);
    }

    /**
     * @return Second side value
     */
    public float getSecondSideValue() {
        return getFloatInputValue(secondSideField);
    }

    /**
     * @return Third side value
     */
    public float getThirdSideValue() {
        return getFloatInputValue(thirdSideField);
    }

    /**
     * @param inputField Input field holding the value
     * @return Float value parsed from specified input field
     */
    private float getFloatInputValue(JTextField inputField) {
        float val = Float.valueOf(inputField.getText()).floatValue();

        if (val < Triangle.LOWER_BOUND) {
            throw new NumberFormatException("Must be greater than or equals to " + Triangle.LOWER_BOUND);
        }

        if (val > Triangle.UPPER_BOUND) {
            throw new NumberFormatException("Must be less than or equals to " + Triangle.UPPER_BOUND);
        }

        return val;
    }
}
