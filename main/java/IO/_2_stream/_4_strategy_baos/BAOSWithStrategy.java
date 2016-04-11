package IO._2_stream._4_strategy_baos;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BAOSWithStrategy extends OutputStream {
    private static final int DEFAULT_START_SIZE = 16;
    private static final AllocateStrategy DEFAULT_ALLOCATE_STRATEGY = new DoubleAllocateStrategy();

    private final AllocateStrategy strategy;
    private final List<byte[]> bufferList = new ArrayList<>(16);
    private int count = 0;

    public BAOSWithStrategy() {
        this(DEFAULT_START_SIZE, DEFAULT_ALLOCATE_STRATEGY);
    }

    public BAOSWithStrategy(int startSize) {
        this(startSize, DEFAULT_ALLOCATE_STRATEGY);
    }

    public BAOSWithStrategy(AllocateStrategy strategy) {
        this(DEFAULT_START_SIZE, strategy);
    }

    public BAOSWithStrategy(int startSize, AllocateStrategy strategy) {
        this.bufferList.add(new byte[startSize]);
        this.strategy = strategy;
    }

    @Override
    public void write(int b) throws IOException {
        byte[] lastBuff = bufferList.get(bufferList.size() - 1);
        if (count == lastBuff.length) {
            int newSize = strategy.nextAfter(lastBuff.length);
            byte[] newLastBuff = new byte[newSize];
            bufferList.add(newLastBuff);
            count = 0;
            lastBuff = newLastBuff;
        }
        lastBuff[count++] = (byte) b;
    }

    @Override
    public void write(byte[] bytes) throws IOException {
        write(bytes, 0, bytes.length);
    }

    @Override
    public void write(byte[] bytes, int off, int len) throws IOException {
        for (int k = off; k < off + len; k++) {
            byte b = bytes[k];
            write(b & 0xFF);
        }
    }

    public void writeTo(OutputStream out) throws IOException {
        byte[] data = bufferList.get(bufferList.size() - 1);
        out.write(data,0,count);
    }

    public byte[] toByteArray() {
        byte[] data=bufferList.get(bufferList.size()-1);
        byte[] result=new byte[count];
        System.arraycopy(data, 0, result, 0, count);
        return result;
    }
}
