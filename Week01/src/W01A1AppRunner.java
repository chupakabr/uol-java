/**
 * Created by myltik
 * Created on 7/5/13 4:45 PM
 */
public class W01A1AppRunner {

    public static void main(String[] args) {
        try {
            W01A1App app = new W01A1App();
            app.run();
        } catch (Throwable t) {
            System.err.println("An error has occured: " + t.getMessage());
        }
    }
}
