import java.awt.*;

/**
 * Created by myltik
 * Created on 8/21/13 4:08 PM
 */
interface Movable {

    /**
     * Move object to new position.
     * @param movingStrategy
     */
    void move(MovingStrategy movingStrategy, Rectangle bounds);

}
