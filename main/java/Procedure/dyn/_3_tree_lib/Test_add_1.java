package Procedure.dyn._3_tree_lib;

public class Test_add_1 {
    public static void main(String[] args) {
        // CALL
        TreeNode root = TreeUtils.add(null, 5);
        // CHECK
        String expectedStr = "(()5())";
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
