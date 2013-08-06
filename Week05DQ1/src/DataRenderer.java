/**
 * Created by myltik
 * Created on 8/4/13 4:16 PM
 */
public interface DataRenderer<T> {

    /**
     * Render specified data and return HTML representation
     * @param data
     * @return HTML representation string
     */
    String render(T data);

}
