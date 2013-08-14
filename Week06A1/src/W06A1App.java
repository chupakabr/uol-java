import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

/**
 * Sorting is a frequent array operation.  An array can be sorted if there is an ordering relation between
 * the elements in the array.  For example, if the array consists of a set of integer elements, we can order
 * the elements according to the integer number line.  A common method whereby the elements in an array may be
 * sorted is called the bubble sort.  Assuming an array of positive integers which we wish to sort according to
 * the sequence represented by the integer number line, the bubble sort operates as follows:
 * 1. Find the two adjacent elements, X and Y, in the array such that X > Y and swap X and Y,
 *    then sort the resulting array.
 * 2. If there is no adjacent pair of elements, X and Y, in the array such that X > Y , the list is sorted.
 *
 * Note that the purpose of swapping two elements X and Y that occur out of order is so that after the swap,
 * the new list is closer to a sorted list.  After a sufficient amount of swapping, we should end up with all the
 * elements in order.
 *
 * For example given the array:
 *   {1 2 5 4 7 3 6 8 10 9}
 * we would commence by finding the elements 5 and 4 and swap them to get:
 *   {1 2 4 5 7 3 6 8 10 9}
 * We would then continue as follows:
 *   {1 2 4 5 7 3 6 8 10 9}
 *   {1 2 4 5 3 7 6 8 10 9}
 *   {1 2 4 3 5 7 6 8 10 9}
 *   {1 2 3 4 5 7 6 8 10 9}
 *   {1 2 3 4 5 6 7 8 10 9}
 *   {1 2 3 4 5 6 7 8 9 10}
 *
 * The process is known as a bubble sort because elements slowly bubble up to their correct location.
 * Design and implement a Java program which sorts a 10 element integer array using the bubble sort process.
 * The elements of the array to be sorted should be supplied by the user (assume the user will not input duplicates).
 *
 * Create a GUI front end for your bubble sort program.
 * The result should look something like that presented in Figure 1.
 * You may use any graphic element to create your display - JOptionPanes are the easiest and most basic tools
 * available to you, but you may also experiment with additional GUI controls such as JFrames, JPanels, etc
 * I would advise you to use objects from the Swing library (those objects begin with 'J') as opposed to objects
 * from the AWT library - Swing objects are a little easier to use and are ultimately more flexible and robust
 * than AWT objects.
 *
 * In the example below, there are 10 text fields on a JFrame background to allow input of array elements
 * (remember that for each text field you must press the carriage return key to invoke the listener).
 * When the array has been populated, we press the start button, at which point the given array is output as a label.
 * We then sort the result and output the sorted array.
 *
 * Created by myltik
 * Created on 8/13/13 6:40 PM
 */
public class W06A1App implements Runnable, ActionListener {

    private final int ELEMENTS_NUMBER = 10;

    private static final Color OK_COLOR = Color.BLACK;
    private static final Color ERROR_COLOR = Color.RED;

    private final SortingStrategy<Integer> sortingStrategy;

    private final List<JTextField> inputFields;
    private JLabel initialArrayLabel;
    private JLabel resultsArrayLabel;
    private JButton processButton;

    public W06A1App() {
        inputFields = new ArrayList<JTextField>(ELEMENTS_NUMBER);
        sortingStrategy = new BubbleSortStrategy<Integer>();
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
        JFrame frame = new JFrame("Bubble Sort");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buildUI(frame.getContentPane());

        frame.setMinimumSize(new Dimension(480, 110));
        frame.pack();
        frame.setResizable(true);
        frame.setVisible(true);
    }

    /**
     * Build UI
     */
    private void buildUI(final Container mainPane) {

        //
        // Input pane

        Random rnd = new Random(System.currentTimeMillis());
        JPanel inputPane = new JPanel();
        inputPane.setLayout(new BoxLayout(inputPane, BoxLayout.X_AXIS));
        for (int i = 0; i < ELEMENTS_NUMBER; ++i) {
            inputFields.add(i, new JTextField("" + rnd.nextInt(100), 5));
            inputPane.add(inputFields.get(i));
        }


        //
        // Result labels and sort button

        initialArrayLabel = new JLabel("  Initial array: ");
        initialArrayLabel.setMinimumSize(new Dimension(300, 50));

        resultsArrayLabel = new JLabel("  Sorted array: ");
        resultsArrayLabel.setMinimumSize(new Dimension(300, 50));

        processButton = new JButton("Sort");
        processButton.addActionListener(this);

        JPanel resultsPane = new JPanel();
        resultsPane.setLayout(new BoxLayout(resultsPane, BoxLayout.Y_AXIS));
        resultsPane.add(processButton);
        resultsPane.add(initialArrayLabel);
        resultsPane.add(resultsArrayLabel);


        //
        // Add everything to main pane

        mainPane.add(inputPane, BorderLayout.PAGE_START);
        mainPane.add(resultsPane, BorderLayout.PAGE_END);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        boolean hasErrors = false;
        List<Integer> initial = new ArrayList<Integer>(ELEMENTS_NUMBER);
        for (JTextField textField : inputFields) {
            try {
                initial.add(Integer.valueOf(textField.getText()));
                textField.setForeground(OK_COLOR);
            } catch (NumberFormatException e) {
                hasErrors = true;
                textField.setForeground(ERROR_COLOR);
            }
        }

        if (!hasErrors) {
            Collection<Integer> result = sortingStrategy.sort(initial);

            initialArrayLabel.setText("  Initial array:  " + initial.toString());
            resultsArrayLabel.setText("  Sorted array: " + result.toString());
        }
    }
}
