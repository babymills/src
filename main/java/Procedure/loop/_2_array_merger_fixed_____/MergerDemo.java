package Procedure.loop._2_array_merger_fixed_____;

import java.util.Arrays;

public class MergerDemo {

    public static void main(String[] args) {
        int[][][] data = {
                {{}, {}},
                {{0}, {}},
                {{}, {0}},
                {{0}, {0}},
                {{0, 2}, {1, 3}},
                {{0, 2, 7, 9, 123}, {1, 3, 4, 5, 6}},
                {{10}, {1, 2, 19, 20}},
        };
        for (int[][] origin : data) {
            int[] left = origin[0];
            int[] right = origin[1];
            int[] merged = Merger.merge(left, right);
            System.out.println(
                    Arrays.toString(left) +
                            " + " +
                            Arrays.toString(right) +
                            " -> " +
                            Arrays.toString(merged));
        }
    }
}
