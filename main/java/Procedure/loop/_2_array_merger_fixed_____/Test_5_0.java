package Procedure.loop._2_array_merger_fixed_____;

import java.util.Arrays;

public class Test_5_0 {

    public static void main(String[] args) {
        int[] result = Merger.merge(new int[]{1, 2, 3, 4, 5}, new int[]{});

        if (!Arrays.equals(result, new int[]{1, 2, 3, 4, 5})) {
            throw new AssertionError();
        }

        System.out.print("OK");
    }
}
