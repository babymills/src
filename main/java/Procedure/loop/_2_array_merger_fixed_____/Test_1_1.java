package Procedure.loop._2_array_merger_fixed_____;

import java.util.Arrays;

public class Test_1_1 {

    public static void main(String[] args) {
        int[] result = Merger.merge(new int[]{1}, new int[]{2});

        if (!Arrays.equals(result, new int[]{1, 2})) {
            throw new AssertionError();
        }

        System.out.print("OK");
    }
}
