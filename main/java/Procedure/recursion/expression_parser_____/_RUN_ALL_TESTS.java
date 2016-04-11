package Procedure.recursion.expression_parser_____;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class _RUN_ALL_TESTS {

    public static final String[] TESTS = {
            "Test_0",
            "Test_00",
            "Test_1",
            "Test_2",
            "Test_3",
            "Test_4",
            "Test_10",
            "Test_20",
            "Test_30",
            "Test_40",
            "Test_102",
            "Test_203",
            "Test_304",
            "Test_401",
            "Test_1020",
            "Test_2030",
            "Test_3040",
            "Test_4010",
            "Test_10203",
            "Test_20304",
            "Test_30401",
            "Test_40102",
    };

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        for (String test : TESTS) {
            Class testClass = Class.forName(new Exception().getStackTrace()[0].getClassName().replace("_RUN_ALL_TESTS", "") + test);
            Method mainMethod = testClass.getDeclaredMethod("main", new Class[]{String[].class});
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            try {
                mainMethod.invoke(null,(Object) null);
            } catch (Throwable t) {
                System.err.println("- TEST FAILED (exception): " + test);
                continue;
            }
            if (!Arrays.equals("OK".getBytes(StandardCharsets.US_ASCII), out.toByteArray())) {
                System.err.println("- TEST FAILED (not 'OK' in System.out): " + test);
                continue;
            }
            System.err.println("TEST OK: " + test);
        }
    }
}
