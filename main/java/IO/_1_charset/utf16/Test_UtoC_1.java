package IO._1_charset.utf16;

import java.util.Arrays;

public class Test_UtoC_1 {

    public static void main(String[] args) {
        // PREPARE
        int[] expectedCodePoints = {1};
        String str = new String(expectedCodePoints, 0, expectedCodePoints.length);
        char[] utf16 = str.toCharArray();

        // CALL
        int[] actualCodePoints = UTF16Converter.convertUTF16toCodepoint(utf16);

        // CHECK
        if (!Arrays.equals(actualCodePoints, expectedCodePoints)) {
            throw new AssertionError("actualCodePoints=" + Arrays.toString(actualCodePoints) + " is not equal expectedCodePoints=" + Arrays.toString(expectedCodePoints));
        }
        System.out.print("OK");
    }
}
