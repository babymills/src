package IO._1_charset.utf8;

import java.util.Arrays;

import static java.lang.Character.MAX_CODE_POINT;
import static java.nio.charset.StandardCharsets.UTF_8;

public class Test_UtoC_all {

    public static void main(String[] args) {
        // PREPARE
        int[] expectedCodePoints = new int[MAX_CODE_POINT + 1];
        for (int point = 0; point <= MAX_CODE_POINT; point++) {
            if ((point < 0xD800) || (0xDFFF < point)) {
                expectedCodePoints[point] = point;
            }
        }
        String str = new String(expectedCodePoints, 0, expectedCodePoints.length);
        byte[] utf8 = str.getBytes(UTF_8);

        // CALL
        int[] actualCodepoint = UTF8Converter.convertUTF8toCodepoint(utf8);

        // CHECK
        if (!Arrays.equals(actualCodepoint, expectedCodePoints)) {
            throw new AssertionError();
        }

        System.out.print("OK");
    }
}
