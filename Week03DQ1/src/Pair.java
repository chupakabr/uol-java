/**
 * Created by myltik
 * Created on 7/21/13 8:53 PM
 */
abstract public class Pair<T extends Number> {

    protected T first;
    protected T second;

    public Pair(T first, T second) {
        assert first != null;
        assert second != null;

        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }
}
