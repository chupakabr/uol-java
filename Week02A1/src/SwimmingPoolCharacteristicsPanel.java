import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 *
 * Swimming pool characteristics input fields container.
 * Used to ask a user to input swimming pool characteristics which are width, length and depth.
 *
 * Created by myltik
 * Created on 7/15/13 2:57 PM
 */
public class SwimmingPoolCharacteristicsPanel extends JPanel {

    protected final JLabel statusLabel;
    protected final JTextField widthField;
    protected final JTextField lengthField;
    protected final JTextField depthField;

    public SwimmingPoolCharacteristicsPanel() {
        super(new BorderLayout());

        //
        // Information message

        this.add(new JLabel("Please input swimming pool dimensions in meters"), BorderLayout.NORTH);


        //
        // Input fields

        final Border inputNameBorder = BorderFactory.createEmptyBorder(5, 0, 5, 0);

        final JLabel widthLabel = new JLabel("Width:");
        widthLabel.setBorder(inputNameBorder);

        final JLabel lengthLabel = new JLabel("Length:");
        lengthLabel.setBorder(inputNameBorder);

        final JLabel depthLabel = new JLabel("Depth:");
        depthLabel.setBorder(inputNameBorder);

        final JPanel inputNamesContainer = new JPanel();
        inputNamesContainer.setLayout(new BoxLayout(inputNamesContainer, BoxLayout.Y_AXIS));
        inputNamesContainer.add(widthLabel);
        inputNamesContainer.add(lengthLabel);
        inputNamesContainer.add(depthLabel);

        JPanel inputFieldsContainer = new JPanel();
        inputFieldsContainer.setLayout(new BoxLayout(inputFieldsContainer, BoxLayout.Y_AXIS));
        widthField = new JTextField(10);
        lengthField = new JTextField(10);
        depthField = new JTextField(10);
        inputFieldsContainer.add(widthField);
        inputFieldsContainer.add(lengthField);
        inputFieldsContainer.add(depthField);

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
            getWidthValue();
        } catch (NumberFormatException e) {
            statusLabel.setText("Invalid value for [width] property, should be a number greater than 0");
            return false;
        }

        try {
            getLengthValue();
        } catch (NumberFormatException e) {
            statusLabel.setText("Invalid value for [length] property, should be a number greater than 0");
            return false;
        }

        try {
            getDepthValue();
        } catch (NumberFormatException e) {
            statusLabel.setText("Invalid value for [depth] property, should be a number greater than 0");
            return false;
        }

        return true;
    }

    /**
     * @return Width value
     */
    public float getWidthValue() {
        return getFloatInputValue(widthField);
    }

    /**
     * @return Length value
     */
    public float getLengthValue() {
        return getFloatInputValue(lengthField);
    }

    /**
     * @return Depth value
     */
    public float getDepthValue() {
        return getFloatInputValue(depthField);
    }

    /**
     * @param inputField Input field holding the value
     * @return Float value parsed from specified input field
     */
    private float getFloatInputValue(JTextField inputField) {

        float val = Float.valueOf(inputField.getText()).floatValue();
        if (val <= 0f) {
            throw new NumberFormatException("Must be greater that 0");
        }
        return val;
    }
}
