package Procedure.dyn._2_single_lib;

import static java.util.Arrays.copyOfRange;

public class Test_InsertInPosition_5_0 {

    public static void main(String[] args) {

        Node expected = _(0, 1, 2, 3, 4, 5);
        String expectedAsString = toString(expected);

        Node actual = SingleLLUtils.insertInPosition(_(1, 2, 3, 4, 5), 0, 0);
        String actualAsString = toString(actual);

        if (!expectedAsString.equals(actualAsString)) {
            throw new AssertionError("expected = '" + expectedAsString + "' but actual = '" + actualAsString + "'");
        }

        System.out.print("OK");
    }

    public static Node _(int... values) {
        return values.length == 0 ? null : new Node(values[0], _(copyOfRange(values, 1, values.length)));
    }

    public static String toString(Node tail) {
        return (tail == null) ? "*" : tail.value + "->" + toString(tail.next);
    }

}
