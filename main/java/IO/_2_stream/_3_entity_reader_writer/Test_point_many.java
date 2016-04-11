package IO._2_stream._3_entity_reader_writer;

import IO._2_stream.EntityInput;
import IO._2_stream.EntityOutput;
import IO._2_stream.Point;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class Test_point_many {
    public static void main(String[] args) throws IOException {
        // PREPARE
        StringWriter buff = new StringWriter();
        EntityOutput out = new EntityOutputWriter(buff);
        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
                out.writePoint(new Point(x, y));
            }
        }
        String str = buff.toString();
        EntityInput entityInput = new EntityInputReader(new StringReader(str));
        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
                // CALL
                Point point = entityInput.readPoint();
                // CHECK
                if (point.getX() != x) {
                    throw new AssertionError();
                }
                if (point.getY() != y) {
                    throw new AssertionError();
                }
            }
        }

        System.out.print("OK");
    }
}
