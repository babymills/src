package Procedure.dyn._5_fibonacci_tree;

public class Test_arg_1 {
    public static void main(String[] args) {
        // CALL
        TreeNode root = FibonacciTreeUtils.generateArg(1);
        // CHECK
        String expectedStr = "(()1())";
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
