package IO._2_stream._4_strategy_baos;

import java.io.IOException;
import java.util.Arrays;

public class Test_2_4_w0_toBA {
    public static void main(String[] args) throws IOException {
        BAOSWithStrategy buff = new BAOSWithStrategy(4);
        buff.write(123);
        buff.write(-123);

        byte[] rawData = buff.toByteArray();
        
        if (!Arrays.equals(rawData, new byte[]{123, -123})) {
            throw new AssertionError();
        }

        System.out.print("OK");
    }
}
