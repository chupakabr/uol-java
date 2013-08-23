import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by myltik
 * Created on 8/23/13 6:55 PM
 */
public class BundledImageLoader implements ImageLoader {

    private static final String[] IMAGE_EXTENSIONS = new String[] {"jpeg", "jpg", "png", "gif"};

    private final List<File> imageFiles;

    public BundledImageLoader(String lookupPath) {
        if (lookupPath == null) {
            throw new IllegalArgumentException("Lookup path must be set for BundledImageLoader");
        }

        imageFiles = new ArrayList<File>();

        File dir = new File(lookupPath);
        if (dir == null || !dir.isDirectory()) {
            throw new IllegalArgumentException("Specified lookup path is not a directory: " + lookupPath);
        }

        for (File file : dir.listFiles()) {
            if (isImageFile(file)) {
                imageFiles.add(file);
            }
        }

        System.out.println("Found " + imageFiles.size() + " bundled images");
    }

    /**
     * Check whether specified file is image file
     * @param file    File to check
     * @return true if image file, false otherwise
     */
    private boolean isImageFile(File file) {
        if (file == null) return false;
        if (file.isDirectory()) return false;
        if (!file.isFile()) return false;

        String name = file.getName().toLowerCase();
        for (String ext : IMAGE_EXTENSIONS) {
            if (name.endsWith(ext)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public List<BufferedImage> all() throws CannotLoadImageException {
        List<BufferedImage> images = new ArrayList<BufferedImage>(size());

        for (File file : imageFiles) {
            try {
                images.add(ImageIO.read(file));
            } catch (IOException e) {
                throw new CannotLoadImageException(e);
            }
        }

        return images;
    }

    @Override
    public int size() {
        return imageFiles.size();
    }

    @Override
    public BufferedImage get(int idx) throws CannotLoadImageException {
        if (idx >= size()) {
            idx = size()-1; // gentle error handling
        }

        try {
            return ImageIO.read(imageFiles.get(idx));
        } catch (IOException e) {
            throw new CannotLoadImageException(e);
        }
    }
}
