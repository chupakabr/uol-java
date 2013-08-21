import java.awt.*;

/**
 * Created by myltik
 * Created on 8/21/13 4:20 PM
 */
public class EarthPhysicsMovingStrategy implements MovingStrategy {

    private final int STEP_LENGTH_PX = 2;

    private Coordinates current;
    private int currentAngle;

    public EarthPhysicsMovingStrategy(Coordinates initialCoordinates, int startAngle) {
        current = initialCoordinates;
        currentAngle = startAngle;
    }

    @Override
    public Coordinates nextCoordinates(Rectangle bounds, Dimension objectSize) {

        return current;
    }
}
