package Procedure.dyn._3_tree_lib;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class _RUN_ALL_TESTS {

    public static final String[] TESTS = {
            // test: add
            "Test_add_1",
            "Test_add_L",
            "Test_add_M",
            "Test_add_LL",
            "Test_add_MM",
            "Test_add_LM",
            "Test_add_ML",
            "Test_add_LMLM",
            "Test_add_MLML",
            // test: contains
            "Test_contains_1_yes",
            "Test_contains_1_no_l",
            "Test_contains_1_no_r",
            "Test_contains_L_no_0",
            "Test_contains_L_no_1",
            "Test_contains_L_yes_0",
            "Test_contains_L_yes_1",
            "Test_contains_R_no_0",
            "Test_contains_R_no_1",
            "Test_contains_R_yes_0",
            "Test_contains_R_yes_1",
            "Test_contains_LMLM_no_0",
            "Test_contains_LMLM_no_1",
            "Test_contains_LMLM_yes",
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
