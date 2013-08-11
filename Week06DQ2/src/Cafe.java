import java.util.*;

/**
 * Simple cafe implementation
 *
 * Created by myltik
 * Created on 8/11/13 9:11 PM
 */
public class Cafe {

    private final int tablesCount;
    private int freeTablesCount;
    private final Map<ServedTable, Visitor> tables;
    private final Queue<Visitor> queue;

    public Cafe(final int tablesCount) {
        this.tablesCount = tablesCount;

        queue = new LinkedList<Visitor>();

        tables = new HashMap<ServedTable, Visitor>(tablesCount);
        for (int i = 0; i < tablesCount; ++i) {
            tables.put(new ServedTable(i), null);
        }

        freeTablesCount = this.tablesCount;
    }

    /**
     * A visitor came to the cafe
     *
     * @param visitor
     */
    public final synchronized void onVisitorCome(Visitor visitor) {
        if (visitor == null) {
            return;
        }

        if (freeTablesCount > 0) {
            for (ServedTable table : tables.keySet()) {
                if (tables.get(table) == null) {
                    tables.put(table, visitor);
                    break;
                }
            }

            --freeTablesCount;

        } else {
            queue.offer(visitor);
        }
    }

    /**
     * A visitor left the cafe.
     *
     * @param visitor
     */
    public final synchronized void onVisitorLeave(Visitor visitor) {
        if (visitor == null) {
            return; // not in the cafe for some reason
        }

        ServedTable freeTable = null;
        for (ServedTable table : tables.keySet()) {

            if (visitor.equals(tables.get(table))) {
                tables.put(table, null);
                ++freeTablesCount;
                freeTable = table;
                break;
            }

            if (freeTable == null && tables.get(table) == null) {
                freeTable = table;
            }
        }

        if (freeTablesCount > 0 && freeTable != null) {
            Visitor nextInTheQueue = queue.poll();
            if (nextInTheQueue != null) {
                tables.put(freeTable, nextInTheQueue);
                --freeTablesCount;
            }
        }
    }

    @Override
    public synchronized String toString() {
        return "Cafe with " + tablesCount + " tables (free " + freeTablesCount
                + "), current visitors: " + tables.values()
                + ", currently queueing: " + queue;
    }
}
