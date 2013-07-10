/**
 * Created by myltik
 * Created on 7/10/13 2:11 PM
 */
public class W02DQ1AppRunner {

    public static void main(String[] args) {
        try {
            W02DQ1App app = new W02DQ1App();
            app.run();
        } catch (Throwable t) {
            t.printStackTrace();
            System.err.println("An error has occured: " + t.getMessage());
        }
    }
}
