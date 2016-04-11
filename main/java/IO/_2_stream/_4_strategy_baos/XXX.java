package IO._2_stream._4_strategy_baos;

import java.io.IOException;

public class XXX {
    public static void main(String[] args) throws IOException {
        BAOSWithStrategy buff = new BAOSWithStrategy(4);
        buff.write(new byte[] {123});
        buff.write(new byte[] {-123});



        byte[] rawData = buff.toByteArray();
        for(byte b:rawData)
        System.out.println(b);

    }
}
