package IO._1_charset.utf8;

import java.util.Arrays;

import static java.lang.Character.MAX_CODE_POINT;
import static java.nio.charset.StandardCharsets.UTF_8;

public class Test_CtoU_all {

    public static void main(String[] args) {
        // PREPARE
        int[] codePoints = new int[MAX_CODE_POINT + 1];
        for (int point = 0; point <= MAX_CODE_POINT; point++) {
            if ((point < 0xD800) || (0xDFFF < point)) {
                codePoints[point] = point;
            }
        }
        String str = new String(codePoints, 0, codePoints.length);
        byte[] utf8 = str.getBytes(UTF_8);

        // CALL
        byte[] actualUFT8 = UTF8Converter.convertCodepointToUTF8(codePoints);

        // CHECK
        if (!Arrays.equals(actualUFT8, utf8)) {
            throw new AssertionError();
        }
        System.out.print("OK");
    }
}
