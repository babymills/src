package IO._2_stream._2_entity_is_os;

import IO._2_stream.EntityOutput;
import IO._2_stream.Point;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Test_point_0_1 {
    public static void main(String[] args) throws IOException {
        // PREPARE
        ByteArrayOutputStream buff = new ByteArrayOutputStream();
        EntityOutput out = new EntityOutputStream(buff);
        out.writePoint(new Point(0, 1));
        byte[] rawBytes = buff.toByteArray();

        // CALL
        Point point = new EntityInputStream(new ByteArrayInputStream(rawBytes)).readPoint();

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
