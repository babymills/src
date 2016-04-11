package Procedure.loop.matrix_mul;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class _RUN_ALL_TESTS {

    public static final String[] TESTS = {
            "Test_1x1_x_1x1",
            "Test_1x1_x_2x1_BAD",
            "Test_1x2_x_1x1_BAD",
            "Test_1x3_x_3x2",
            "Test_2x2_x_2x2",
            "Test_2x3_x_3x1",
            "Test_3x3_x_3x3",
            "Test_3x3_x_BAD_00",
            "Test_3x3_x_BAD_01",
            "Test_3x3_x_BAD_10",
            "Test_3x3_x_BAD_11",
            "Test_3x3_x_BAD_20",
            "Test_3x3_x_BAD_21",
            "Test_3x3_x_BAD_30",
            "Test_3x3_x_BAD_31",
            "Test_BAD_00_x_3x3",
            "Test_BAD_01_x_3x3",
            "Test_BAD_10_x_3x3",
            "Test_BAD_11_x_3x3",
            "Test_BAD_20_x_3x3",
            "Test_BAD_21_x_3x3",
            "Test_BAD_30_x_3x3",
            "Test_BAD_31_x_3x3",
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
