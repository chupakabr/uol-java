/**
 * Created by myltik
 * Created on 7/21/13 8:47 PM
 */
public class W03DQ1AppRunner {

    public static void main(String[] args) {
        try {
            W03DQ1App app = new W03DQ1App();
            app.run();
        } catch (Throwable t) {
            t.printStackTrace();
            System.err.println("An error has occured: " + t.getMessage());
        }
    }
}
