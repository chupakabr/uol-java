import java.util.HashMap;
import java.util.Map;

/**
 * Created by myltik
 * Created on 8/11/13 9:17 PM
 */
public class ServedTable {

    private final int id;
    private final Map<String, Double> receipt;

    public ServedTable(int id) {
        this.id = id;

        receipt = new HashMap<String, Double>();
    }

    public synchronized void addDish(String dishName, Double cost) {
        receipt.put(dishName, cost);
    }

    public synchronized double calculateReceipt() {
        double result = 0d;

        for (double val : receipt.values()) {
            result += val;
        }

        return result;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServedTable that = (ServedTable) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Table #" + id;
    }
}
