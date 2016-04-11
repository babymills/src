package IO._2_stream._4_strategy_baos;

public class DoubleAllocateStrategy implements AllocateStrategy {
    public int nextAfter(int now) {
        return now * 2;
    }
}
