import java.awt.image.BufferedImage;
import java.util.List;

/**
 * Created by myltik
 * Created on 8/23/13 6:55 PM
 */
public interface ImageLoader {

    /**
     * Load all images.
     * @return Loaded images list
     * @throws CannotLoadImageException
     */
    List<BufferedImage> all() throws CannotLoadImageException;

    /**
     * @return Number of images found
     */
    int size();

    /**
     * @param idx
     * @return Image by its index in the list ordered by image name
     * @throws CannotLoadImageException
     */
    BufferedImage get(int idx) throws CannotLoadImageException;

}
