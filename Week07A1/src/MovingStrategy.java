import java.awt.*;

/**
 * Created by myltik
 * Created on 8/21/13 4:09 PM
 */
public interface MovingStrategy {

    /**
     * Get next coordinates to move the object to
     * @param bounds
     * @param objectSize
     * @return Coordinates
     */
    Coordinates nextCoordinates(Rectangle bounds, Dimension objectSize);
}
