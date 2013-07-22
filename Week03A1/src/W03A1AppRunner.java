/**
 * Created by myltik
 * Created on 7/22/13 5:19 PM
 */
public class W03A1AppRunner {

    public static void main(String[] args) {
        try {
            W03A1App app = new W03A1App();
            app.run();
        } catch (Throwable t) {
            t.printStackTrace();
            System.err.println("An error has occured: " + t.getMessage());
        }
    }
}
