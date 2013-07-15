/**
 * Created by myltik
 * Created on 7/15/13 1:39 PM
 */
public class W02A1AppRunner {

    public static void main(String[] args) {
        try {
            W02A1App app = new W02A1App();
            app.run();
        } catch (Throwable t) {
            t.printStackTrace();
            System.err.println("An error has occured: " + t.getMessage());
        }
    }
}
