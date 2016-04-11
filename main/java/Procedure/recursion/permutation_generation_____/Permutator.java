package Procedure.recursion.permutation_generation_____;

import java.util.ArrayList;
import java.util.List;

public class Permutator {

    public static List<List<Integer>> permute(List<Integer> list, int size) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (size < 2) {
            result.add(list);
        } else {
            for (int k = 0; k < size; k++) {
                swap(list, k, size - 1);
                result.addAll(permute(list, size - 1));
                swap(list, k, size - 1);
            }
        }
        return result;
    }

    private static void swap(List<Integer> list, int index0, int index1) {
        Integer tmp = list.get(index0);
        list.set(index0, list.get(index1));
        list.set(index1, tmp);
    }
}
