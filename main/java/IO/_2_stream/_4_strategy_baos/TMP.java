package IO._2_stream._4_strategy_baos;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TMP {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        for (int k = 0; k < 1000; k++) {
            out.write((int) (1000 * Math.random()));
        }
        byte[] rawData = out.toByteArray();

        List<Double> list = new ArrayList<>();
        for (int k = 0; k < 1000; k++) {
            list.add(1000 * Math.random());
        }
    }
}
