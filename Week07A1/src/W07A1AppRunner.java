import javax.swing.*;

/**
 * Created by myltik
 * Created on 8/21/13 3:48 PM
 */
public class W07A1AppRunner {

    public static void main(String[] args) {
        try {
            SwingUtilities.invokeLater(new W07A1App());
        } catch (Throwable t) {
            t.printStackTrace();
            System.err.println("An error has occured: " + t.getMessage());
        }
    }
}
