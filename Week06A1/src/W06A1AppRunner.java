import javax.swing.*;

/**
 * Created by myltik
 * Created on 8/13/13 6:40 PM
 */
public class W06A1AppRunner {

    public static void main(String[] args) {
        try {
            SwingUtilities.invokeLater(new W06A1App());
        } catch (Throwable t) {
            t.printStackTrace();
            System.err.println("An error has occured: " + t.getMessage());
        }
    }
}
