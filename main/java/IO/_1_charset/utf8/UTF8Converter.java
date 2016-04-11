package IO._1_charset.utf8;

import java.util.Arrays;

public class UTF8Converter {

    public static int[] convertUTF8toCodepoint(byte[] utf8) {
        int[] result = new int[utf8.length];
        int posIn = 0;
        int posOut = 0;
        while (posIn < utf8.length) {
            byte octet0 = utf8[posIn++];
            if ((octet0 & 0b1000_0000) == 0) {
                result[posOut++] = octet0;
            } else if ((octet0 & 0b0010_0000)==0){
                byte octet1 = utf8[posIn++];
                result[posOut++] = ((octet0 & 0b0001_1111) << 6) + (octet1 & 0b00111111);
            } else if ((octet0 & 0b0001_0000)==0){
                byte octet1 = utf8[posIn++];
                byte octet2 = utf8[posIn++];
                result[posOut++] = ((octet0 & 0b0000_1111) <<12 ) + ((octet1 & 0b00111111)<<6)+(octet2 & 0b00111111);
            } else if((octet0 & 0b0000_1000)==0){
                byte octet1 = utf8[posIn++];
                byte octet2 = utf8[posIn++];
                byte octet3 = utf8[posIn++];
                result[posOut++] =
                 ((octet0 & 0b0000_0111) <<18 ) + ((octet1 & 0b00111111)<<12)+((octet2 & 0b00111111)<<6)+(octet3 & 0b00111111);
            }
        }
        return Arrays.copyOfRange(result, 0, posOut);
    }
/*Unicode UTF-8:
0x00000000 — 0x0000007F: 0xxxxxxx
0x00000080 — 0x000007FF: 110xxxxx 10xxxxxx
0x00000800 — 0x0000FFFF: 1110xxxx 10xxxxxx 10xxxxxx
0x00010000 — 0x001FFFFF: 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
0x00200000 — 0x03FFFFFF: 111110xx 10xxxxxx 10xxxxxx 10xxxxxx 10xxxxxx
0x04000000 — 0x7FFFFFFF: 1111110x 10xxxxxx 10xxxxxx 10xxxxxx 10xxxxxx 10xxxxxx*/

    public static byte[] convertCodepointToUTF8(int[] codePoint) {
        byte[] result = new byte[4 * codePoint.length];
        int posIn = 0;
        int posOut = 0;
        while (posIn < codePoint.length) {
            int point = codePoint[posIn++];
            if (point < 0x000080) {
                result[posOut++] = (byte) point;
            } else if(point<'\u0800'){
                result[posOut++] = (byte) (((point >> 6) & 0b0001_1111) | 0b1100_0000);
                result[posOut++] = (byte) ((point & 0b0011_1111) | 0b1000_0000);
            }else if(point< 0x00010000){
                result[posOut++] = (byte) (((point >> 12) & 0b0000_1111) | 0b1110_0000);
                result[posOut++] = (byte) (((point >> 6) & 0b0011_1111) | 0b1000_0000);
                result[posOut++] = (byte) ((point & 0b0011_1111) | 0b1000_0000);
            }else if(point<0x00200000){
                result[posOut++] = (byte) (((point >> 18) & 0b0000_0111) | 0b1111_0000);
                result[posOut++] = (byte) (((point >> 12) & 0b0011_1111) | 0b1000_0000);
                result[posOut++] = (byte) (((point >> 6) & 0b0011_1111) | 0b1000_0000);
                result[posOut++] = (byte) ((point & 0b0011_1111) | 0b1000_0000);
            }
        }
        return Arrays.copyOfRange(result, 0, posOut);
    }
}

