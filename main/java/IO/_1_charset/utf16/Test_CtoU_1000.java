package IO._1_charset.utf16;

import java.util.Arrays;

public class Test_CtoU_1000 {

    public static void main(String[] args) {
        // PREPARE
        int[] codePoints = {1_000};
        String str = new String(codePoints, 0, codePoints.length);
        char[] expectedUTF16 = str.toCharArray();

        // CALL
        char[] actualUFT16 = UTF16Converter.convertCodepointToUTF16(codePoints);

        // CHECK
        if (!Arrays.equals(actualUFT16, expectedUTF16)) {
            throw new AssertionError("actualUFT8=" + toString(actualUFT16) + " is not equal expectedUTF8=" + toString(expectedUTF16));
        }
        System.out.print("OK");
    }

    public static String toString(char[] arr) {
        StringBuilder builder = new StringBuilder("[");
        for (char c : arr) {
            builder.append((int) c).append(", ");
        }
        builder.delete(builder.length() - 2, builder.length());
        return builder.append("]").toString();
    }
}
