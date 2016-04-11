package Collections._1_equals_hashCode_1.entity_a;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class _RUN_ALL_TESTS {

    public static final String[] TESTS = {
            "equals.Test_same",
            "equals.Test_null",

            "equals.Test_OON",
            "equals.Test_OOO",
            "equals.Test_OOX",
            "equals.Test_OXN",
            "equals.Test_OXO",
            "equals.Test_OXX",
            "equals.Test_XON",
            "equals.Test_XOO",
            "equals.Test_XOX",
            "equals.Test_XXN",
            "equals.Test_XXO",
            "equals.Test_XXX",

            "equals.Test_N_OON",
            "equals.Test_N_OOO",
            "equals.Test_N_OXN",
            "equals.Test_N_OXO",
            "equals.Test_N_XON",
            "equals.Test_N_XOO",
            "equals.Test_N_XXN",
            "equals.Test_N_XXO",
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
