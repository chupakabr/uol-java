/**
 * Created by myltik
 * Created on 7/30/13 7:52 PM
 */
public class Launcher {

    private final Movable projectile;
    private final Angle launchAngle;
    private final NatureEnvironment environment;

    private Double travelledDistance = null;

    /**
     * @param projectile     Projectile to be launched
     * @param launchAngle    Launch angle
     * @param environment    Nature environment where to launch a projectile
     */
    public Launcher(Movable projectile, Angle launchAngle, NatureEnvironment environment) {
        if (projectile == null || launchAngle == null || environment == null) {
            throw new IllegalStateException("Cannot instantiate Launcher with null parameters");
        }

        this.projectile = projectile;
        this.launchAngle = launchAngle;
        this.environment = environment;
    }

    /**
     * Lazy evaluation of travelled distance
     * @return Travelled distance in meters
     */
    public Double getTravelledDistance() {
        if (travelledDistance == null) {
            synchronized (this) {
                if (travelledDistance == null) {
                    travelledDistance = calculateTravelledDistance();
                }
            }
        }

        return travelledDistance;
    }

    /**
     * Calculate travelled distance
     * @return Travelled distance in meters
     */
    private Double calculateTravelledDistance() {
        final double vu = projectile.getSpeed() * Math.sin(launchAngle.getRadians());
        final double hu = projectile.getSpeed() * Math.cos(launchAngle.getRadians());
        final double t = (2 * vu) / environment.getGravity();

        return hu * t;
    }

    @Override
    public String toString() {
        return "Launcher{" +
                "projectile=" + projectile +
                ", launchAngle=" + launchAngle +
                ", environment=" + environment +
                '}';
    }
}
