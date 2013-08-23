/**
 * Created by myltik
 * Created on 8/23/13 7:15 PM
 */
public class CannotLoadImageException extends Exception {

    public CannotLoadImageException() {
    }

    public CannotLoadImageException(String s) {
        super(s);
    }

    public CannotLoadImageException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public CannotLoadImageException(Throwable throwable) {
        super(throwable);
    }
}
