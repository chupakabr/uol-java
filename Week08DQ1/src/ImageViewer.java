import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Created by myltik
 * Created on 8/23/13 6:55 PM
 */
public class ImageViewer extends JPanel implements ChangeListener {

    private final ImageLoader imageLoader;

    private final JSlider slider;
    private JLabel imageLabel;

    public ImageViewer(ImageLoader imageLoader) throws CannotLoadImageException {
        if (imageLoader == null) {
            throw new IllegalArgumentException("Image loader must be set");
        }
        this.imageLoader = imageLoader;
        imageLabel = new JLabel(imageForIndex(0));

        slider = new JSlider(JSlider.HORIZONTAL, 1, imageLoader.size(), 1);
        slider.setMinorTickSpacing(1);
        slider.setMajorTickSpacing(1);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.addChangeListener(this);

        // Init UI
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(slider);
        add(imageLabel);
    }


    /**
     * Create JLabel and insert an image to it
     * @param idx Image index in the image loader
     * @return JLabel with image inserted
     * @throws CannotLoadImageException
     */
    private ImageIcon imageForIndex(int idx) throws CannotLoadImageException {
        if (imageLoader.size() <= 0 || imageLoader.size() <= idx) {
            throw new IllegalStateException("Attempt to load image for index " + idx
                    + " while loader has only " + imageLoader.size() + " images");
        }

        return new ImageIcon(imageLoader.get(idx));
    }

    @Override
    public synchronized void stateChanged(ChangeEvent changeEvent) {
        try {
            imageLabel.setIcon(imageForIndex(slider.getValue()-1));
        } catch (CannotLoadImageException e) {
            throw new IllegalStateException(e);
        }
    }
}
