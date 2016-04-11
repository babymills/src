package Procedure.loop._2_array_merger_fixed_____;

import java.util.Arrays;

public class Test_3_1 {

    public static void main(String[] args) {
        int[] result = Merger.merge(new int[]{1, 1, 2}, new int[]{10});

        if (!Arrays.equals(result, new int[]{1, 1, 2, 10})) {
            throw new AssertionError();
        }

        System.out.print("OK");
    }
}
