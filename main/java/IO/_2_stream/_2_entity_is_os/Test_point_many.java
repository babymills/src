package IO._2_stream._2_entity_is_os;

import IO._2_stream.EntityInput;
import IO._2_stream.EntityOutput;
import IO._2_stream.Point;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Test_point_many {
    public static void main(String[] args) throws IOException {
        // PREPARE
        ByteArrayOutputStream buff = new ByteArrayOutputStream();
        EntityOutput out = new EntityOutputStream(buff);
        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
                out.writePoint(new Point(x, y));
            }
        }
        byte[] rawBytes = buff.toByteArray();

        EntityInput entityInput = new EntityInputStream(new ByteArrayInputStream(rawBytes));
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
