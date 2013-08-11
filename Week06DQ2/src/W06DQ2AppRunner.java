/**
 * Created by myltik
 * Created on 8/11/13 4:40 PM
 */
public class W06DQ2AppRunner {

    public static void main(String[] args) {
        try {
            new W06DQ2App().run();
        } catch (Throwable t) {
            t.printStackTrace();
            System.err.println("An error has occured: " + t.getMessage());
        }
    }
}
