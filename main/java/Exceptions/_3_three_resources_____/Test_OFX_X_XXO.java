package Exceptions._3_three_resources_____;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test_OFX_X_XXO {
    public static void main(String[] args) throws Throwable {
        // PREPARE
        final List<String> history = new ArrayList<>();

        final AutoCloseable resourceA = new AutoCloseable() {
            public void close() throws Exception {
                history.add("resourceA.close()");
            }
        };
        final AutoCloseable resourceB = new AutoCloseable() {
            public void close() throws Exception {
                history.add("resourceB.close()");
            }
        };
        final AutoCloseable resourceC = new AutoCloseable() {
            public void close() throws Exception {
                history.add("resourceC.close()");
            }
        };
        AutoCloseableFactory factoryA = new AutoCloseableFactory() {
            public AutoCloseable create() throws Throwable {
                history.add("factoryA.create()");
                return resourceA;
            }
        };
        AutoCloseableFactory factoryB = new AutoCloseableFactory() {
            public AutoCloseable create() throws Throwable {
                history.add("factoryB.create()");
                throw new Error("factoryB");
            }
        };
        AutoCloseableFactory factoryC = new AutoCloseableFactory() {
            public AutoCloseable create() throws Throwable {
                history.add("factoryC.create()");
                return resourceC;
            }
        };
        TryBody body = new TryBody() {
            public void runBody() throws Throwable {
                history.add("body.runBody()");
            }
        };

        // CALL
        try {
            Dispatcher.call(factoryA, factoryB, factoryC, body);
        } catch (Error e) {
            if (!"factoryB".equals(e.getMessage())) {
                throw new AssertionError();
            }
            if (e.getSuppressed().length != 0) {
                throw new AssertionError();
            }
        }

        // CHECK
        if (!history.equals(Arrays.asList(
                "factoryA.create()", "factoryB.create()",
                "resourceA.close()"))) {
            throw new AssertionError(history.toString());
        }

        System.out.print("OK");
    }
}
