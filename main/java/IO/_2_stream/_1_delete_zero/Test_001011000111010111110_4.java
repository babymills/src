package IO._2_stream._1_delete_zero;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class Test_001011000111010111110_4 {

    public static void main(String[] args) throws IOException {
        // PREPARE
        final int BUFF_LEN = 4;
        final byte[] DATA = {0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0};

        final List<String> actualHistory = new ArrayList<>();
        InputStream src = new ByteArrayInputStream(DATA) {
            public int read() {
                actualHistory.add("read()");
                return super.read();
            }

            private boolean log = true;

            public int read(byte[] b) throws IOException {
                actualHistory.add("read(b[" + b.length + "])");
                log = false;
                try {
                    return super.read(b);
                } finally {
                    log = true;
                }
            }

            public int read(byte[] b, int off, int len) {
                if (log) {
                    actualHistory.add("read(b[" + b.length + "]," + off + "," + len + ")");
                }
                return super.read(b, off, len);
            }
        };
        ByteArrayOutputStream dst = new ByteArrayOutputStream() {
            public void write(int b) {
                actualHistory.add("write(1)");
                super.write(b);
            }

            @Override
            public void write(byte[] b) throws IOException {
                actualHistory.add("write(b[" + b.length + "])");
                super.write(b);
            }

            @Override
            public void write(byte[] b, int off, int len) {
                actualHistory.add("write(b[" + b.length + "]," + off + "," + len + ")");
                super.write(b, off, len);
            }
        };

        // CALL
        ZeroFilter.filter(src, dst, BUFF_LEN);

        // CHECK
        if (!Arrays.equals(dst.toByteArray(), new byte[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1})) {
            throw new AssertionError();
        }
        List<String> expectedHistory = asList(
                "read(b[4])", "write(b[4],2,1)",
                "read(b[4])", "write(b[4],0,2)",
                "read(b[4])", "write(b[4],1,3)",
                "read(b[4])", "write(b[4],1,1)", "write(b[4],3,1)",
                "read(b[4])", "write(b[4],0,4)",
                "read(b[4])",
                "read(b[4])"
        );
        if (!actualHistory.equals(expectedHistory)) {
            throw new AssertionError("actual:" + actualHistory + " != expectedHistory:" + expectedHistory);
        }

        System.out.print("OK");
    }
}
