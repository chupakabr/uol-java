import java.awt.*;

/**
 * Created by myltik
 * Created on 8/21/13 4:25 PM
 */
public class VerticalMovingStrategy implements MovingStrategy {

    private final int STEP_LENGTH_PX = 2;

    private Coordinates current;
    private boolean isDownDirection;

    public VerticalMovingStrategy(Coordinates initialCoordinates, boolean isDownDirection) {
        current = initialCoordinates;
        this.isDownDirection = isDownDirection;
    }

    @Override
    public Coordinates nextCoordinates(Rectangle bounds, Dimension objectSize) {

        if (isDownDirection && current.y + objectSize.height >= bounds.getHeight()) {
            isDownDirection = false;
        } else if (!isDownDirection && current.y <= bounds.y ) {
            isDownDirection = true;
        }

        if (isDownDirection) {
            current = new Coordinates(current.x, current.y+STEP_LENGTH_PX);
        } else {
            current = new Coordinates(current.x, current.y-STEP_LENGTH_PX);
        }

        return current;
    }
}
