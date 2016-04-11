package Procedure.recursion.permutation_generation_____;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;

public class Test_5 {
    public static void main(String[] args) {
        List<List<Integer>> actual = Permutator.permute(asList(1, 2, 3, 4, 5), 5);
        List<List<Integer>> expected = anotherPermute(5);

        checkDuplicates(actual);
        checkNoElements(actual, expected);
        checkMoreElements(actual, expected);

        System.out.print("OK");
    }

    private static void checkDuplicates(List<List<Integer>> actual) {
        if (actual.size() != new HashSet<>(actual).size()) {
            List<List<Integer>> actualCopy = new ArrayList<>(actual);
            Set<List<Integer>> actualSet = new HashSet<>(actual);
            for (List<Integer> elem : actualSet) {
                actualCopy.remove(elem);
            }
            throw new AssertionError("You have duplicates: " + new HashSet<>(actualCopy) + " in " + actual);
        }
    }

    private static void checkNoElements(List<List<Integer>> actual, List<List<Integer>> expected) {
        ArrayList<List<Integer>> expectedCopy = new ArrayList<>(expected);
        expectedCopy.removeAll(actual);
        if (expectedCopy.size() > 0) {
            throw new AssertionError("You don't have elements: actual=" + actual + " expected=" + expected + " expected\\actual=" + expectedCopy);
        }
    }

    private static void checkMoreElements(List<List<Integer>> actual, List<List<Integer>> expected) {
        ArrayList<List<Integer>> actualCopy = new ArrayList<>(actual);
        actualCopy.removeAll(expected);
        if (actualCopy.size() > 0) {
            throw new AssertionError("You have more elements: actual=" + actual + " expected=" + expected + " actual\\expected=" + actualCopy);
        }
    }

    public static List<List<Integer>> anotherPermute(int size) {
        if (size == 1) {
            return asList(asList(1));
        } else {
            List<List<Integer>> result = new ArrayList<>();
            List<List<Integer>> subResult = anotherPermute(size - 1);
            for (List<Integer> elem : subResult) {
                for (int index = 0; index < elem.size(); index++) {
                    List<Integer> newElem = new ArrayList<>(elem);
                    newElem.add(index, size);
                    result.add(newElem);
                }
                List<Integer> newElem = new ArrayList<>(elem);
                newElem.add(size);
                result.add(newElem);
            }
            return result;
        }
    }
}
