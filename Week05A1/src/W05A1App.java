import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Write a program that computes the annual road tax (vehicle excise duty) charges for three types of vehicles:
 * vans, cars and motorcycles.
 *
 * The road tax rate is calculated as follows for each type of vehicle:
 *
 * Vans
 * Light goods vehicles weighing less than 3500kg are charged at 165 GBP (British Pounds); otherwise they are
 * charged at 190 GBP.
 *
 * Cars
 * All cars registered on or before 1 March 2001 are charged according to their engine size (in cc).
 * A car with an engine size of less than or equal to 1550cc is charged at 110 GBP; otherwise it is charged at 165 GBP.
 *
 * If the date of car’s registration is after 1 March 2001, the annual road tax charge is calculated according to
 * the CO2 emission of the vehicle.  The table below displays the different road tax charges for this criterion.
 * (Hint: see the API documentation for the Date and DateFormat class)
 *
 * Petrol Car
 *
 * CO2 Emission Figure (g/km)            12 months rate in GBP
 * -----------------------------         ------------------------
 * Up to 100                             65.00
 * 101 to 120                            75.00
 * 121 – 150                             105.00
 * 151 – 165                             125.00
 * 166 – 185                             145.00
 * Over 185                              160.00
 *
 * Table 1:  Road tax charges for private vehicles registered on or after 1 March 2001
 *
 * For the data-entry enthusiasts who only believe in entering real and precise data, there is a website
 * (http://www.vcacarfueldata.org.uk/ved/index.asp ) that can calculate for you the real CO2 emission for
 * different models of cars, but you don’t need this information.  Remember, this program is only meant to
 * represent a model solution that works for this problem.
 *
 * Motorcycles
 * Motorcycles are charged according to their engine size (in cc).
 * The following table displays the list of road tax charges according to this criterion.
 *
 * Motorcycles
 * Motorcycles (with or without sidecar)      12 months rate in GBP
 * -------------------------------            ------------------------------
 * Not Over 150cc                             15.00
 * 151cc - 400cc                              30.00
 * 401cc - 600cc                              45.00
 * All other motorcycles                      60.0
 *
 * Table 2:  Road tax charges for motorcycles
 * Task
 * Create an invoicing system that will ask the user to input a vehicle’s
 * a)         Manufacturer name (e.g. Toyota)
 * b)         Model (e.g. Avensis)
 * c)         Date of registration (e.g. 17/12/2002)
 * d)         Engine size (moto) / CO2 Emission (car) / Weight (vehicle)
 *
 * Depending on the type of vehicle (van, car or motorcycle), the program should proceed to produce an invoice
 * containing the above input details as well as the amount of road tax charge to be paid for that particular vehicle.
 *
 * Created by myltik
 * Created on 8/1/13 7:40 PM
 */
public class W05A1App implements Runnable, ActionListener, ItemListener {

    private static final String CAR = "Car";
    private static final String VAN = "Van";
    private static final String MOTO = "Motorcycle";

    private static final Color OK_COLOR = Color.BLACK;
    private static final Color ERROR_COLOR = Color.RED;

    private static final int MANUFACTURER_FIELD_IDX = 0;
    private static final int MODEL_FIELD_IDX = 1;
    private static final int REGISTRATION_DATE_FIELD_IDX = 2;
    private static final int ENGINE_VOLUME_FIELD_IDX = 3;
    private static final int WEIGHT_FIELD_IDX = 4;
    private static final int CO2EMISSION_FIELD_IDX = 4;

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    private String lastShownCard;
    private JPanel cardsPane;
    private JLabel resultsLabel;

    public W05A1App() {
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
        JFrame frame = new JFrame("Vehicle Road Tax");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buildUI(frame.getContentPane());

        frame.setMinimumSize(new Dimension(480, 260));
        frame.pack();
        frame.setResizable(true);
        frame.setVisible(true);
    }

    /**
     * Build UI
     */
    private void buildUI(final Container mainPane) {

        //
        // Combobox to select vehicle type

        JComboBox combobox = new JComboBox(new String[] {CAR, VAN, MOTO});
        combobox.setEditable(false);
        combobox.addItemListener(this);

        JPanel comboboxPane = new JPanel(new FlowLayout());
        comboboxPane.add(combobox);


        //
        // Specific pane for selected vehicle type

        cardsPane = new JPanel(new CardLayout());
        cardsPane.add(buildCarPane(), CAR);
        cardsPane.add(buildVanPane(), VAN);
        cardsPane.add(buildMotoPane(), MOTO);


        //
        // Result field and calculate button

        resultsLabel = new JLabel("");
        resultsLabel.setMinimumSize(new Dimension(200, 50));

        JButton button = new JButton("Calculate Road Tax");
        button.addActionListener(this);

        JPanel resultsPane = new JPanel();
        resultsPane.setLayout(new BoxLayout(resultsPane, BoxLayout.X_AXIS));
        resultsPane.add(button);
        resultsPane.add(resultsLabel);


        //
        // Add everything to main pane

        mainPane.add(comboboxPane, BorderLayout.PAGE_START);
        mainPane.add(cardsPane, BorderLayout.CENTER);
        mainPane.add(resultsPane, BorderLayout.PAGE_END);
    }

    /**
     * @return Pane with input fields for a car
     */
    private JPanel buildCarPane() {
        JPanel pane = buildCommonPane();

        JTextField  co2EmissionTextField = new JTextField(7);
        appendInputFieldWithLabelToPane(pane, co2EmissionTextField, "CO2 Emission (g/km):",
                (JComponent) pane.getComponent(1 + ENGINE_VOLUME_FIELD_IDX * 2));

        return pane;
    }

    /**
     * @return Pane with input fields for a van
     */
    private JPanel buildVanPane() {
        JPanel pane = buildCommonPane();

        JTextField  weightTextField = new JTextField(7);
        appendInputFieldWithLabelToPane(pane, weightTextField, "Weight (kg):",
                (JComponent) pane.getComponent(1 + ENGINE_VOLUME_FIELD_IDX * 2));

        return pane;
    }

    /**
     * @return Pane with input fields for a motorcycle
     */
    private JPanel buildMotoPane() {
        return buildCommonPane();
    }

    /**
     * @return Pane with the following input fields: manufacturer, model, registration date
     */
    private JPanel buildCommonPane() {
        JPanel pane = new JPanel(new SpringLayout());

        JTextField manufacturerTextField = new JTextField(20);
        JTextField modelTextField = new JTextField(20);
        JTextField registrationDateTextField = new JTextField(10);
        JTextField engineSizeTextField = new JTextField(7);

        appendInputFieldWithLabelToPane(pane, manufacturerTextField, "Manufacturer:", pane);
        appendInputFieldWithLabelToPane(pane, modelTextField, "Model:", manufacturerTextField);
        appendInputFieldWithLabelToPane(pane, registrationDateTextField, "Registered on (DD/MM/YYYY):", modelTextField);
        appendInputFieldWithLabelToPane(pane, engineSizeTextField, "Engine size (cc):", registrationDateTextField);

        return pane;
    }

    /**
     * Append specified input field with specified label to a pane
     * @param pane
     * @param inputField
     * @param labelText
     */
    private void appendInputFieldWithLabelToPane(
            JPanel pane,
            JComponent inputField,
            String labelText,
            JComponent relativeTo)
    {
        SpringLayout layout = (SpringLayout) pane.getLayout();

        JLabel label = new JLabel(labelText);

        pane.add(label);
        pane.add(inputField);

        layout.putConstraint(SpringLayout.WEST, label, 5, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, label, 10, relativeTo == pane ? SpringLayout.NORTH : SpringLayout.SOUTH, relativeTo);

        layout.putConstraint(SpringLayout.WEST, inputField, 120, SpringLayout.EAST, pane.getComponent(0));
        layout.putConstraint(SpringLayout.NORTH, inputField, 5, relativeTo == pane ? SpringLayout.NORTH : SpringLayout.SOUTH, relativeTo);
    }

    /**
     * @param idx
     * @return Text field value as String
     */
    private JTextField getTextFieldByIndex(int idx) {
        JPanel inputFieldsContainer;
        if (VAN.equals(lastShownCard)) {
            inputFieldsContainer = (JPanel) cardsPane.getComponent(1);
        } else if (MOTO.equals(lastShownCard)) {
            inputFieldsContainer = (JPanel) cardsPane.getComponent(2);
        } else {
            inputFieldsContainer = (JPanel) cardsPane.getComponent(0);
        }

        return (JTextField) inputFieldsContainer.getComponent(1 + idx*2);
    }

    /**
     * @param idx
     * @return Text field value as String
     */
    private String getTextValueByFieldIndex(int idx) {
        return getTextFieldByIndex(idx).getText();
    }

    /**
     * @param idx
     * @return Text field value as Double
     * @throws NumberFormatException
     */
    private Double getDoubleValueByFieldIndex(int idx) throws NumberFormatException {
        return Double.valueOf(getTextValueByFieldIndex(idx));
    }

    /**
     * @param idx
     * @return Text field value as Date, null if date string is malformed
     * @throws ParseException
     */
    private Date getDateValueByFieldIndex(int idx) throws ParseException {
        return DATE_FORMAT.parse(getTextValueByFieldIndex(idx));
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String manufacturer = getTextValueByFieldIndex(MANUFACTURER_FIELD_IDX);
        String model = getTextValueByFieldIndex(MODEL_FIELD_IDX);

        // ignore exceptions, they will be rethrown in Vehicle's constructor during validation

        Date regDate = null;
        try { regDate = getDateValueByFieldIndex(REGISTRATION_DATE_FIELD_IDX); }
        catch (ParseException e) {}

        Double co2emission = null;
        try { co2emission = getDoubleValueByFieldIndex(CO2EMISSION_FIELD_IDX); }
        catch (NumberFormatException e) {}
        catch (ArrayIndexOutOfBoundsException e) {}

        Double weight = null;
        try { weight = getDoubleValueByFieldIndex(WEIGHT_FIELD_IDX); }
        catch (NumberFormatException e) {}
        catch (ArrayIndexOutOfBoundsException e) {}

        Double engineVolume = null;
        try { engineVolume = getDoubleValueByFieldIndex(ENGINE_VOLUME_FIELD_IDX); }
        catch (NumberFormatException e) {}

        // Create vehicle, validate and display result or error
        Vehicle vehicle;
        try {
            if (VAN.equals(lastShownCard)) {
                vehicle = new Van(manufacturer, model, regDate, weight);
            } else if (MOTO.equals(lastShownCard)) {
                vehicle = new Motorcycle(manufacturer, model, regDate, engineVolume);
            } else {
                vehicle = new Car(manufacturer, model, regDate, engineVolume, co2emission);
            }

            resultsLabel.setForeground(OK_COLOR);
            resultsLabel.setText("Annual road tax charge is " + vehicle.getAnnualRoadTaxCharge());
        } catch (MissingParametersException e) {
            resultsLabel.setForeground(ERROR_COLOR);
            resultsLabel.setText(e.getMessage());
        }
    }

    @Override
    public synchronized void itemStateChanged(ItemEvent itemEvent) {
        lastShownCard = (String)itemEvent.getItem();

        CardLayout cl = (CardLayout) cardsPane.getLayout();
        cl.show(cardsPane, lastShownCard);

        resultsLabel.setText("");
    }
}
