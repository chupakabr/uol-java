import javax.swing.*;

/**
 * Created by myltik
 * Created on 8/23/13 5:38 PM
 */
public class W08DQ1AppRunner {

    public static void main(String[] args) {
        try {
            SwingUtilities.invokeLater(new W08DQ1App());
        } catch (Throwable t) {
            t.printStackTrace();
            System.err.println("An error has occured: " + t.getMessage());
        }
    }
}
