/**
 * Created by myltik
 * Created on 8/21/13 4:09 PM
 */
public class Coordinates implements Cloneable {

    public final int x;
    public final int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Coordinates(x, y);
    }
}
