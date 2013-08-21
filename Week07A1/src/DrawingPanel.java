import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by myltik
 * Created on 8/21/13 4:10 PM
 */
public class DrawingPanel extends JPanel {

    private final List<DynamicVisualObject> movableObjects;
    private final MovingStrategy movingStrategy;

    private final AtomicBoolean isRunning;

    public DrawingPanel(int width, int height, DynamicVisualObject obj) {
        movableObjects = new ArrayList<DynamicVisualObject>();
        movableObjects.add(obj);

        isRunning = new AtomicBoolean(false);

        this.movingStrategy = new VerticalMovingStrategy(new Coordinates(width/2, height/2), true);

        setPreferredSize(new Dimension(width, height));

        // On mouse pressed event listener to start/stop redrawing (moving) movable objects
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                if (!isRunning.compareAndSet(true, false)) {
                    isRunning.compareAndSet(false, true);
                }
            }
        });
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponents(graphics);

        if (isRunning.get()) {
            graphics.clearRect(0, 0, getBounds().width, getBounds().height);

            for (DynamicVisualObject movable : movableObjects) {
                movable.move(movingStrategy, getBounds());
                movable.update(graphics);
            }
        }
    }
}
