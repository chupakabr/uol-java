import javax.swing.*;

/**
 * Created by myltik
 * Created on 7/26/13 4:40 PM
 */
public class W04DQ1AppRunner {

    public static void main(String[] args) {
        try {
            SwingUtilities.invokeLater(new W04DQ1App());
        } catch (Throwable t) {
            t.printStackTrace();
            System.err.println("An error has occured: " + t.getMessage());
        }
    }
}
