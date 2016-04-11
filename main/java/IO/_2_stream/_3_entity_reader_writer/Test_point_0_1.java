package IO._2_stream._3_entity_reader_writer;

import IO._2_stream.EntityOutput;
import IO._2_stream.Point;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class Test_point_0_1 {
    public static void main(String[] args) throws IOException {
        // PREPARE
        StringWriter buff = new StringWriter();
        EntityOutput out = new EntityOutputWriter(buff);
        out.writePoint(new Point(0, 1));
        String str = buff.toString();

        // CALL
        Point point = new EntityInputReader(new StringReader(str)).readPoint();

        // CHECK
        if (point.getX() != 0) {
            throw new AssertionError();
        }
        if (point.getY() != 1) {
            throw new AssertionError();
        }
        
        System.out.print("OK");
    }
}
