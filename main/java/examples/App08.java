package examples;

import java.io.UnsupportedEncodingException;
//(byte)  63; /*  63 0x3f 0b00111111 (ignored tag, skip to next byte) */
// (byte)  31; /*  31 0x1f 0b00011111 small negative integer - value in low 4 bits (k+32) */
public class App08 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        byte b= (byte) 0b1000_0000;
        byte b1= (byte) 0b1100_0000;
        byte b2 =(byte) 0b00100100;
        byte b3 = (byte)0b0000000010100010;
        byte b4 = (byte)0b0010000010101100;
        System.out.println(100_000 & 0b1000_0000);
        System.out.println(b);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);
    }
}