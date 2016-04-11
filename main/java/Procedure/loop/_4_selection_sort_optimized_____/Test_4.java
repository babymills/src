package Procedure.loop._4_selection_sort_optimized_____;

import java.util.Arrays;

public class Test_4 {
    public static void main(String[] args) {
        // fill elements
        int[] array = new int[] {3, 1, 2, 4};
        // library sort
        int[] expected = array.clone();
        Arrays.sort(expected);
        // lab sort
        int[] actual = array.clone();
        SelectionSorter.sort(actual);
        // compare results: library vs lab
        if (!Arrays.equals(actual, expected)) {
            throw new AssertionError("expected = " + Arrays.toString(expected) + " but actual  = " + Arrays.toString(actual));
        }

        System.out.print("OK");
    }
}
