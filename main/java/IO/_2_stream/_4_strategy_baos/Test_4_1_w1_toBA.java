package IO._2_stream._4_strategy_baos;

import java.io.IOException;
import java.util.Arrays;

public class Test_4_1_w1_toBA {
    public static void main(String[] args) throws IOException {
        BAOSWithStrategy buff = new BAOSWithStrategy(4);
        buff.write(new byte[] {0});
        buff.write(new byte[] {127, -128, -1});

        byte[] rawData = buff.toByteArray();
        
        if (!Arrays.equals(rawData, new byte[]{0, 127, -128, -1})) {
            throw new AssertionError();
        }

        System.out.print("OK");
    }
}
