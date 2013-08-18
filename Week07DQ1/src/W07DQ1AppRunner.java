/**
 * Created by myltik
 * Created on 18/11/13 4:40 PM
 */
public class W07DQ1AppRunner {

    public static void main(String[] args) {
        try {
            new W07DQ1App().run();
        } catch (Throwable t) {
            t.printStackTrace();
            System.err.println("An error has occured: " + t.getMessage());
        }
    }
}
