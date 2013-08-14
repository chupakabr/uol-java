import java.util.ArrayList;
import java.util.List;

/**
 * Created by myltik
 * Created on 8/13/13 7:34 PM
 */
public class BubbleSortStrategy<T extends Number> implements SortingStrategy<T> {

    @Override
    public List<T> sort(List<T> initialData) {
        final List<T> result = new ArrayList<T>(initialData);

        final int size = initialData.size();
        int n = size;
        int newN;
        T tmp;

        while (n > 0) {
            newN = 0;

            for (int i = 1; i < n; ++i) {
                if (result.get(i).doubleValue() < result.get(i-1).doubleValue()) {
                    tmp = result.get(i);
                    result.set(i, result.get(i - 1));
                    result.set(i - 1, tmp);

                    newN = i;
                }
            }

            n = newN;
        }

        return result;
    }
}
