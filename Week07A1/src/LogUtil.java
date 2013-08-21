/**
 * Created by myltik
 * Created on 8/21/13 5:34 PM
 */
public class LogUtil {

    public static void d(String message) {
        System.out.println("DEBUG " + message);
    }

    public static void w(String message) {
        System.err.println("WARN " + message);
    }
}
