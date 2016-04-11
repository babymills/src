package IO._2_stream._4_strategy_baos;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Test_4_1_w0_writeTo {
    public static void main(String[] args) throws IOException {
        BAOSWithStrategy buff = new BAOSWithStrategy(4);
        buff.write(0);
        buff.write(127);
        buff.write(128);
        buff.write(255);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        buff.writeTo(out);
        
        if (!Arrays.equals(out.toByteArray(), new byte[]{0, 127, -128, -1})) {
            throw new AssertionError();
        }

        System.out.print("OK");
    }
}
