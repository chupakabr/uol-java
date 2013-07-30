/**
 * Created by myltik
 * Created on 7/30/13 8:02 PM
 */
public class EarthEnvironment implements NatureEnvironment {

    private static final double GRAVITY = 10f;

    @Override
    public double getGravity() {
        return GRAVITY;
    }

    @Override
    public String toString() {
        return "EarthEnvironment{" +
                "gravity=" + getGravity() +
                '}';
    }
}
