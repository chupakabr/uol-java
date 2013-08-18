import static java.lang.System.out;

/**
 * Created by myltik
 * Created on 18/11/13 4:40 PM
 */
public class W07DQ1App implements Runnable {

    public W07DQ1App() {
    }

    /**
     * Simulate a cafe with only 2 tables.
     */
    @Override
    public void run() {
        final int size = 6;
        test("Figure 26.5 (Thread-unsafe)", new SimpleArrayFig26d5(size));
        test("Figure 26.8 (Thread-safe)", new SimpleArrayFig26d8(size));
    }

    private void test(String testName, MutableArray array) {
        out.println("");
        out.println("==================================");
        out.println("Start testing " + testName);
        out.println("");

        new ArrayTest().test(array);

        out.println("");
        out.println("Finish testing " + testName);
        out.println("==================================");
        out.println("");
    }
}
