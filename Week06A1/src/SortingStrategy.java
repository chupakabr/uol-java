import java.util.List;

/**
 * Created by myltik
 * Created on 8/13/13 7:32 PM
 */
public interface SortingStrategy<T extends Number> {

    /**
     * Sort specified collection.
     *
     * @param initialData
     * @return Sorted collection
     */
    List<T> sort(List<T> initialData);

}
