package Procedure.dyn._5_fibonacci_tree;

public class Test_res_5 {
    public static void main(String[] args) {
        // CALL
        TreeNode root = FibonacciTreeUtils.generateRes(5);
        // CHECK
        String expectedStr = "(((()1())3((()1())2(()1())))8(((()1())2(()1()))5((()1())3((()1())2(()1())))))";
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
