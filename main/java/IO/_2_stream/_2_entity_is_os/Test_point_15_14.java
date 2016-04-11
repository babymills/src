package IO._2_stream._2_entity_is_os;

import IO._2_stream.EntityOutput;
import IO._2_stream.Point;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Test_point_15_14 {
    public static void main(String[] args) throws IOException {
        // PREPARE
        ByteArrayOutputStream buff = new ByteArrayOutputStream();
        EntityOutput out = new EntityOutputStream(buff);
        out.writePoint(new Point(15, 14));
        byte[] rawBytes = buff.toByteArray();

        // CALL
        Point point = new EntityInputStream(new ByteArrayInputStream(rawBytes)).readPoint();

        // CHECK
        if (point.getX() != 15) {
            throw new AssertionError("expected = " + 15 + " but actual = " + point.getX());
        }
        if (point.getY() != 14) {
            throw new AssertionError("expected = " + 14 + " but actual = " + point.getY());
        }
        
        System.out.print("OK");
    }
}
