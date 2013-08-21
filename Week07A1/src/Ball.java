import java.awt.*;

/**
 * Created by myltik
 * Created on 8/21/13 4:10 PM
 */
public class Ball extends DynamicVisualObject {

    private static final int DIAMETER_PX = 20;

    private Coordinates prevCoordinates = null;
    private Coordinates coordinates = null;
    private final Dimension size;

    public Ball() {
        size = new Dimension(DIAMETER_PX, DIAMETER_PX);
    }

    @Override
    public void move(MovingStrategy movingStrategy, Rectangle bounds) {
        if (coordinates != null) {
            try {
                prevCoordinates = (Coordinates) coordinates.clone();
            } catch (CloneNotSupportedException e) {
                throw new IllegalStateException(e);
            }
        }

        coordinates = movingStrategy.nextCoordinates(bounds, size);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);

        // Erase previous
        if (prevCoordinates != null) {
            graphics.clearRect(prevCoordinates.x, prevCoordinates.y, size.width, size.height);
        }

        // Draw new
        graphics.setColor(Color.BLUE);
        graphics.fillOval(coordinates.x, coordinates.y, size.width, size.height);
    }

    @Override
    public Dimension getSize() {
        return size;
    }
}
