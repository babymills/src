package examples;

import java.util.Arrays;
import static java.nio.charset.StandardCharsets.UTF_8;
public class App13_CodepointsGetBytes {
    public static void main(String[] args) {
        int[] codePoints0 = {100_000};
        int[] codePoints1 = {10_000};
        int[] codePoints2 = {1_000_000};
        String str0 = new String(codePoints0, 0, codePoints0.length);
        String str1 = new String(codePoints1, 0, codePoints0.length);
        String str2 = new String(codePoints2, 0, codePoints0.length);
        byte[] strBytes0 = str0.getBytes(UTF_8);
        byte[] strBytes1 = str1.getBytes(UTF_8);
        byte[] strBytes2 = str2.getBytes(UTF_8);
      //  byte[] actualUFT8 =  f(codePoints);
        System.out.println(Arrays.toString(strBytes0));
        System.out.println(Arrays.toString(strBytes1));
        System.out.println(Arrays.toString(strBytes2));
        //-13, -76, -119, -128
        long x = 55296;
        long y = 57343;

    }
}
