package Exceptions._2_two_resources_____;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test_OO_F_FO {
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
                throw new Error("closeB");
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
                return resourceB;
            }
        };
        TryBody body = new TryBody() {
            public void runBody() throws Throwable {
                history.add("body.runBody()");
                throw new Error("body");
            }
        };

        // CALL
        try {
            Dispatcher.call(factoryA, factoryB, body);
        } catch (Error e) {
            if (!"body".equals(e.getMessage())) {
                throw new AssertionError();
            }
            if (e.getSuppressed().length != 1) {
                throw new AssertionError();
            }
            if (!"closeB".equals(e.getSuppressed()[0].getMessage())) {
                throw new AssertionError();
            }
        }

        // CHECK
        if (!history.equals(Arrays.asList(
                "factoryA.create()", "factoryB.create()",
                "body.runBody()",
                "resourceB.close()", "resourceA.close()"))) {
            throw new AssertionError();
        }

        System.out.print("OK");
    }
}
