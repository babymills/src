package IO._1_charset.utf16;


import java.util.Arrays;

import static java.lang.Character.isSurrogate;

/*Переписать реализацию класса UTF16Converter, который имеет два метода для преобразования массива
codePoint-ов (int[]) в char[] и char[] в массив codePoint-ов (int[]) согласно кодировки UTF-16BE(???).
Вот “заготовка ответа” (работает только для “маленьких” codePoint-ов):*/
public class UTF16Converter {

    public static int[] convertUTF16toCodepoint(char[] utf16Arr) {
        int[] result = new int[utf16Arr.length];
        int posIn=0;
        int posOut=0;

        while (posIn < utf16Arr.length) {
            if (!isSurrogate(utf16Arr[posIn])) result[posOut++] = utf16Arr[posIn++];
            else {
                int first = utf16Arr[posIn++];
                int second = utf16Arr[posIn++];
                result[posOut++] = (((first  & 0b000000_1111_1111_11)<<10)+0x10_000) + (second & 0b000000_1111_1111_11);
            }
        }
        return Arrays.copyOfRange(result, 0, posOut);
    }

    public static char[] convertCodepointToUTF16(int[] codePointArr) {
        char[] result = new char[2*codePointArr.length];
        int posIn = 0;
        int posOut = 0;

        while (posIn < codePointArr.length) {
            int point = codePointArr[posIn++];
            if (point < Character.MAX_VALUE) {
                result[posOut++] = (char) point;
            } else {
                result[posOut++] = (char) (((point-0x10_000)>>10) | 0b110110_0000_0000_00) /*0xd800*/;//higher
                result[posOut++] = (char) ((point/* & 0b000000_1111_1111_11*/) | 0b110111_0000_0000_00/*0xdc00*/);//lower
            }
        }
        return Arrays.copyOfRange(result, 0, posOut);
    }
}
/*U+1F031 = 1F031hex - 10000hex = F031hex = 0000111100 0000110001bin =
  110110 0000111100 110111 0000110001bin = D83C DC31hex*/

/*U+0000 to U+D7FF uses 2-byte 0000hex to D7FFhex
U+D800 to U+DFFF are invalid codepoints reserved for 4-byte UTF-16
U+E000 to U+FFFF uses 2-byte E000hex to FFFFhex

U+10000 to U+10FFFF uses 4-byte UTF-16 encoded as follows:

Subtract 10000hex from the codepoint.
Express result as 20-bit binary.
Use the pattern 110110xxxxxxxxxx 110111xxxxxxxxxxhex to encode the upper- and lower- 10 bits into two 16-bit words.*/