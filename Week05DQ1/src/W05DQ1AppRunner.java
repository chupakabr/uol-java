import javax.swing.*;

/**
 * Created by myltik
 * Created on 8/1/13 7:40 PM
 */
public class W05DQ1AppRunner {

    public static void main(String[] args) {
        try {
            SwingUtilities.invokeLater(new W05DQ1App());
        } catch (Throwable t) {
            t.printStackTrace();
            System.err.println("An error has occured: " + t.getMessage());
        }
    }
}
