/**
 * Created by myltik
 * Created on 7/21/13 9:00 PM
 */
public class DoublePair extends Pair<Double> {

    public DoublePair(double first, double second) {
        super(first, second);
    }

    /**
     * @return Greatest value of know two
     */
    public Double greatest() {
        return Math.max(first.doubleValue(), second.doubleValue());
    }
}
