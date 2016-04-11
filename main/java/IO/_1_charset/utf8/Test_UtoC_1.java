package IO._1_charset.utf8;

import java.util.Arrays;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Test_UtoC_1 {

    public static void main(String[] args) {
        // PREPARE
        int[] expectedCodePoints = {1};
        String str = new String(expectedCodePoints, 0, expectedCodePoints.length);
        byte[] utf8 = str.getBytes(UTF_8);

        // CALL
        int[] actualCodepoint = UTF8Converter.convertUTF8toCodepoint(utf8);

        // CHECK
        if (!Arrays.equals(actualCodepoint, expectedCodePoints)) {
            throw new AssertionError("actualCodepoint=" + Arrays.toString(actualCodepoint) + " is not equal expectedCodepoint=" + Arrays.toString(expectedCodePoints));
        }

        System.out.print("OK");
    }
}
