package Procedure.loop._2_array_merger_fixed_____;

import java.util.Arrays;

public class Test_3_3 {

    public static void main(String[] args) {
        int[] result = Merger.merge(new int[]{1, 1, 10}, new int[]{5, 5, 100});

        if (!Arrays.equals(result, new int[]{1, 1, 5, 5, 10, 100})) {
            throw new AssertionError();
        }

        System.out.print("OK");
    }
}
