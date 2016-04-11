package IO._1_charset.utf16;

import java.util.Arrays;

public class XXX {
    public static void main(String[] args) {

        int[] codePoints = {100_000};
        String str = new String(codePoints, 0, codePoints.length);
        char[] expectedUTF16 = str.toCharArray();

        char[] actualUFT16 = UTF16Converter.convertCodepointToUTF16(codePoints);

        // CHECK
       System.out.println("actualUFT8=" + Arrays.toString(actualUFT16) + " is not equal expectedUTF8=" + Arrays.toString(expectedUTF16));
       char[] c = "\ud83c\udc31".toCharArray();

        System.out.println(Integer.toHexString(100_000));
        System.out.println(Integer.toBinaryString(100_000));
        char cc = '\uF031';
        System.out.println(Integer.toBinaryString(cc));
        System.out.println(Integer.toHexString(cc));
        System.out.println(Integer.highestOneBit(cc));
        System.out.println(Integer.lowestOneBit(cc));
        System.out.println(c);
    }
    }

