package Procedure.loop._4_selection_sort_optimized_____;

import java.util.Arrays;

public class Test_0 {
    public static void main(String[] args) {
        // fill elements
        int[] array = new int[] {};
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
