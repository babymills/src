package Procedure.dyn._2_single_lib;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class _RUN_ALL_TESTS {

    public static final String[] TESTS = {
            "Test_AddLast_0",
            "Test_AddLast_1",
            "Test_AddLast_2",
            "Test_AddLast_3",
            "Test_AddLast_4",
            "Test_AddLast_5",

            "Test_RemoveLast_1",
            "Test_RemoveLast_2",
            "Test_RemoveLast_3",
            "Test_RemoveLast_4",
            "Test_RemoveLast_5",

            "Test_InsertInPosition_1_0",
            "Test_InsertInPosition_2_1",
            "Test_InsertInPosition_3_0",
            "Test_InsertInPosition_3_1",
            "Test_InsertInPosition_3_2",
            "Test_InsertInPosition_4_0",
            "Test_InsertInPosition_4_1",
            "Test_InsertInPosition_4_2",
            "Test_InsertInPosition_4_3",
            "Test_InsertInPosition_5_0",
            "Test_InsertInPosition_5_1",
            "Test_InsertInPosition_5_2",
            "Test_InsertInPosition_5_3",
            "Test_InsertInPosition_5_4",

            "Test_RemoveInPosition_1_0",
            "Test_RemoveInPosition_2_0",
            "Test_RemoveInPosition_2_1",
            "Test_RemoveInPosition_3_0",
            "Test_RemoveInPosition_3_1",
            "Test_RemoveInPosition_3_2",
            "Test_RemoveInPosition_4_0",
            "Test_RemoveInPosition_4_1",
            "Test_RemoveInPosition_4_2",
            "Test_RemoveInPosition_4_3",
            "Test_RemoveInPosition_5_0",
            "Test_RemoveInPosition_5_1",
            "Test_RemoveInPosition_5_2",
            "Test_RemoveInPosition_5_3",
            "Test_RemoveInPosition_5_4",
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
