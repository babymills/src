package Procedure.dyn._5_fibonacci_tree;

public class Test_arg_0 {
    public static void main(String[] args) {
        // CALL
        TreeNode root = FibonacciTreeUtils.generateArg(0);
        // CHECK
        String expectedStr = "(()0())";
        String actualStr = toString(root);
        if (!expectedStr.equals(actualStr)) {
            throw new AssertionError("expected = " + expectedStr + " but actual = " + actualStr);
        }

        System.out.print("OK");
    }

    public static String toString(TreeNode root) {
        return (root == null) ? "()" : "(" + toString(root.left) + root.value + toString(root.right) + ")";
    }
}
