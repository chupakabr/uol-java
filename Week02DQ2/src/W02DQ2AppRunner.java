/**
 * Created by myltik
 * Created on 7/10/13 2:15 PM
 */
public class W02DQ2AppRunner {

    public static void main(String[] args) {
        try {
            W02DQ2App app = new W02DQ2App();
            app.run();
        } catch (Throwable t) {
            t.printStackTrace();
            System.err.println("An error has occured: " + t.getMessage());
        }
    }
}
