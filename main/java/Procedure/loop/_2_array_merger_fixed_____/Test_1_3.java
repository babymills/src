package Procedure.loop._2_array_merger_fixed_____;

import java.util.Arrays;

public class Test_1_3 {

    public static void main(String[] args) {
        int[] result = Merger.merge(new int[]{2}, new int[]{1, 2, 3});

        if (!Arrays.equals(result, new int[]{1, 2, 2, 3})) {
            throw new AssertionError();
        }

        System.out.print("OK");
    }
}
