package IO._2_stream._4_strategy_baos;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class _RUN_ALL_TESTS {

    public static final String[] TESTS = {
            // toByteArray
            "Test_2_4_w0_toBA",
            "Test_2_4_w1_toBA",
            "Test_2_4_w2_toBA",
            "Test_4_1_w0_toBA",
            "Test_4_1_w1_toBA",
            "Test_4_1_w2_toBA",
            // writeTo
            "Test_2_4_w0_writeTo",
            "Test_2_4_w1_writeTo",
            "Test_2_4_w2_writeTo",
            "Test_4_1_w0_writeTo",
            "Test_4_1_w1_writeTo",
            "Test_4_1_w2_writeTo",
    };

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        for (String test : TESTS) {
            Class testClass = Class.forName(new Exception().getStackTrace()[0].getClassName().replace("_RUN_ALL_TESTS", "") + test);
            Method mainMethod = testClass.getDeclaredMethod("main", new Class[]{String[].class});
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            try {
                mainMethod.invoke(null, (Object) null);
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
