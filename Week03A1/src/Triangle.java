/**
 * Created by myltik
 * Created on 7/22/13 5:59 PM
 */
public class Triangle {

    public static final float LOWER_BOUND = 0f;
    public static final float UPPER_BOUND = 100f;

    protected final float first;
    protected final float second;
    protected final float third;
    protected final TriangleType type;

    /**
     * @param first First side length
     * @param second Second side length
     * @param third Third side length
     */
    public Triangle(float first, float second, float third) {
        assert first > LOWER_BOUND && first <= UPPER_BOUND;
        assert second > LOWER_BOUND && second <= UPPER_BOUND;
        assert third > LOWER_BOUND && third <= UPPER_BOUND;

        this.first = first;
        this.second = second;
        this.third = third;
        this.type = TriangleType.valueOf(first, second, third);
    }

    /**
     * @return First side length
     */
    public float getFirst() {
        return first;
    }

    /**
     * @return Second side length
     */
    public float getSecond() {
        return second;
    }

    /**
     * @return Third side length
     */
    public float getThird() {
        return third;
    }

    /**
     * @return Triangle type
     */
    public TriangleType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                ", type=" + type +
                '}';
    }
}
