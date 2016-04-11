package IO._1_charset.utf8;

import java.util.Arrays;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Test_CtoU_100 {

    public static void main(String[] args) {
        // PREPARE
        int[] codePoints = {100};
        String str = new String(codePoints, 0, codePoints.length);
        byte[] expectedUTF8 = str.getBytes(UTF_8);

        // CALL
        byte[] actualUFT8 = UTF8Converter.convertCodepointToUTF8(codePoints);

        // CHECK
        if (!Arrays.equals(actualUFT8, expectedUTF8)) {
            throw new AssertionError("actualUFT8=" + Arrays.toString(actualUFT8) + " is not equal expectedUTF8=" + Arrays.toString(expectedUTF8));
        }
        System.out.print("OK");
    }
}
