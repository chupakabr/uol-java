import static java.lang.System.out;

/**
 * We have discussed several complex data structure (e. g. linked lists, stacks, queues, and trees),
 * choose one of these complex data structures, and illustrate how you can use it to solve a practical
 * problem (at least 300 words). (This is not a coding task; however, you are welcome to provide a coding solution)
 *
 * Problem:
 * Queueing at a restaurant. First In First Out - FIFO queue.
 *
 * Created by myltik
 * Created on 8/11/13 4:40 PM
 */
public class W06DQ2App implements Runnable {

    public W06DQ2App() {
    }

    /**
     * Simulate a cafe with only 2 tables.
     */
    @Override
    public void run() {
        out.println("START");
        out.println("=================");
        out.println("");

        final Cafe cafe = new Cafe(2);
        out.println("Initial state: " + cafe);

        // Create some visitors
        Visitor v1 = new Visitor("Alex");
        Visitor v2 = new Visitor("Barbie");
        Visitor v3 = new Visitor("Rachel");
        Visitor v4 = new Visitor("Tania");
        Visitor v5 = new Visitor("Rabia");

        // 5 men came, free 0, queue 2
        cafe.onVisitorCome(v1);
        cafe.onVisitorCome(v2);
        cafe.onVisitorCome(v3);
        cafe.onVisitorCome(v4);
        out.println("After 4 men came: " + cafe);

        // 2 men left, free 0, queue 0
        cafe.onVisitorLeave(v2);
        cafe.onVisitorLeave(v1);
        out.println("After 2 men left: " + cafe);

        // 1 man came, free 0, queue 1
        cafe.onVisitorCome(v5);
        out.println("After 1 man came: " + cafe);

        // 2 men left, free 1, queue 0
        cafe.onVisitorLeave(v3);
        cafe.onVisitorLeave(v4);
        out.println("After 2 men left: " + cafe);

        // 1 man came again, free 0, queue 0
        cafe.onVisitorCome(v1);
        out.println("After 1 man came: " + cafe);

        // 1 man left, free 1, queue 0
        cafe.onVisitorLeave(v5);
        out.println("After 1 man left: " + cafe);

        out.println("");
        out.println("=============");
        out.println("END");
    }
}
