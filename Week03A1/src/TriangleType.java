/**
 * Created by myltik
 * Created on 7/22/13 5:37 PM
 */
public enum TriangleType {
    /**
     * All sides are equal
     */
    EQUILATERAL,

    /**
     * Two equal sides
     */
    ISOSCELES,

    /**
     * No equal sides
     */
    SCALENE;

    /**
     * @param side1
     * @param side2
     * @param side3
     * @return Triangle type
     */
    public static TriangleType valueOf(float side1, float side2, float side3) {
        if (side1 == side2 && side1 == side3) {
            return EQUILATERAL;
        } else if (side1 == side2 || side1 == side3 || side2 == side3) {
            return ISOSCELES;
        } else {
            return SCALENE;
        }
    }
}
