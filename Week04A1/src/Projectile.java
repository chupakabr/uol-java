/**
 * Created by myltik
 * Created on 7/30/13 7:52 PM
 */
public class Projectile implements Movable {

    public static final double MIN_SPEED_VALUE = 0f;

    /**
     * Speed of a projectile in m/s
     */
    private final double speed;

    /**
     * @param speed Speed of a projectile in m/s
     * @throws NumberFormatException
     */
    public Projectile(double speed) throws NumberFormatException {
        if (speed <= MIN_SPEED_VALUE) {
            throw new NumberFormatException("Invalid velocity, should be greater than " + MIN_SPEED_VALUE);
        }

        this.speed = speed;
    }

    @Override
    public double getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return "Projectile{" +
                "speed=" + speed +
                '}';
    }
}
