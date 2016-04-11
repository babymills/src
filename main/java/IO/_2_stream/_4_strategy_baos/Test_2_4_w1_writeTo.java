package IO._2_stream._4_strategy_baos;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Test_2_4_w1_writeTo {
    public static void main(String[] args) throws IOException {
        BAOSWithStrategy buff = new BAOSWithStrategy(4);
        buff.write(new byte[] {123});
        buff.write(new byte[] {-123});

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        buff.writeTo(out);
        
        if (!Arrays.equals(out.toByteArray(), new byte[]{123, -123})) {
            throw new AssertionError();
        }

        System.out.print("OK");
    }
}
