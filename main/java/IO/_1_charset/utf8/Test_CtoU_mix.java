package IO._1_charset.utf8;

import java.util.Arrays;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Test_CtoU_mix {

    public static void main(String[] args) {
        // PREPARE
        int[] codePoints = {0, 1, 10, 100, 1_000, 10_000, 100_000, 1_000_000};
        String str = new String(codePoints, 0, codePoints.length);
        byte[] expectedUTF8 = str.getBytes(UTF_8);

        // CALL
        byte[] actualUFT8 = UTF8Converter.convertCodepointToUTF8(codePoints);

        // CHECK
        if (!Arrays.equals(actualUFT8, expectedUTF8)) {
            throw new AssertionError("actual UFT8[] = " + Arrays.toString(actualUFT8) + " is not equal expected UTF8[] = " + Arrays.toString(expectedUTF8));
        }
        System.out.print("OK");
    }
}
