/**
 * Created by myltik
 * Created on 7/15/13 1:39 PM
 */
public class SwimmingPool {

    private static final float WATER_FLOW_IN_LITERS_PER_SECOND = 2.5f;

    protected final float width;
    protected final float length;
    protected final float depth;

    /**
     * @param width Width in meters
     * @param length Length in meters
     * @param depth Depth in meters
     */
    public SwimmingPool(float width, float length, float depth) {
        assert width > 0f;
        assert length > 0f;
        assert depth > 0f;

        this.width = width;
        this.length = length;
        this.depth = depth;
    }

    /**
     * @return Width in meters
     */
    public float getWidth() {
        return width;
    }

    /**
     * @return Length in meters
     */
    public float getLength() {
        return length;
    }

    /**
     * @return Depth in meters
     */
    public float getDepth() {
        return depth;
    }

    /**
     * Evaluate swimming pool volume.
     * @return Swimming pool volume
     */
    public float getVolume() {
        return width * length * depth * 1000f;
    }

    /**
     * Evaluate swimming pool filling time.
     * @return Time in hours needed to fill the swimming pool with water
     */
    public float getFillingHours() {
        return getVolume() / (WATER_FLOW_IN_LITERS_PER_SECOND * 3600);
    }

    @Override
    public String toString() {
        return "SwimmingPool{" +
                "width=" + width +
                ", length=" + length +
                ", depth=" + depth +
                '}';
    }
}
