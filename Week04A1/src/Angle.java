/**
 * Created by myltik
 * Created on 7/30/13 8:01 PM
 */
public class Angle {

    public static final double MIN_VALUE = 0f;
    public static final double MAX_VALUE = 90f;

    private final double angle;
    private final double radians;

    /**
     * @param angle
     * @throws NumberFormatException
     */
    public Angle(double angle) throws NumberFormatException {
        if (angle <= MIN_VALUE) {
            throw new NumberFormatException("Invalid angle, should be greater than " + MIN_VALUE);
        }
        if (angle >= MAX_VALUE) {
            throw new NumberFormatException("Invalid angle, should be less than " + MAX_VALUE);
        }

        this.angle = angle;
        this.radians = Math.toRadians(angle);
    }

    /**
     * @return Angle in degrees
     */
    public double getAngle() {
        return angle;
    }

    /**
     * @return ANgle in radians
     */
    public double getRadians() {
        return radians;
    }

    @Override
    public String toString() {
        return "Angle{" +
                "angle=" + angle +
                '}';
    }
}
