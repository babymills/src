package IO._2_stream._3_entity_reader_writer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class _RUN_ALL_TESTS {

    public static final String[] TESTS = {
            // Point
            "Test_point_0_1",
            "Test_point_14_15",
            "Test_point_many",
            // Person
            "Test_person_O",
            "Test_person_E",
            "Test_person_many",
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
