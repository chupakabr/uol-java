/**
 * Created by myltik
 * Created on 7/9/13 1:50 PM
 */
public class W01AS1AppRunner {

    public static void main(String[] args) {
        try {
            W01AS1App app = new W01AS1App();
            app.run();
        } catch (Throwable t) {
            System.out.println("An error has occured: " + t.getMessage());
        }
    }
}
