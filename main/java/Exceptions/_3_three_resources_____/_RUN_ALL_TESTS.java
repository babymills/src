package Exceptions._3_three_resources_____;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class _RUN_ALL_TESTS {

    public static final String[] TESTS = {
            // 0 exceptions
            "Test_OOO_O_OOO",
            // 1 exception
            "Test_OOO_O_OOF",
            "Test_OOO_O_OFO",
            "Test_OOO_O_OFO",
            "Test_OOO_O_FOO",
            "Test_OOO_F_OOO",
            "Test_OOF_X_XOO",
            "Test_OFX_X_XXO",
            "Test_FXX_X_XXX",
            // 2 exceptions
            "Test_OOO_O_OFF",
            "Test_OOO_O_FOF",
            "Test_OOO_O_FFO",
            "Test_OOO_F_OOF",
            "Test_OOO_F_OFO",
            "Test_OOO_F_FOO",
            "Test_OOF_X_XOF",
            "Test_OOF_X_XFO",
            // 3 exceptions
            "Test_OOO_O_FFF",
            "Test_OOO_F_FFO",
            "Test_OOO_F_OFF",
            "Test_OOF_X_XFF",
            // 4 exceptions
            "Test_OOO_F_FFF",
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
