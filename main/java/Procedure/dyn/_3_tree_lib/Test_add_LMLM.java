package Procedure.dyn._3_tree_lib;

public class Test_add_LMLM {
    public static void main(String[] args) {
        // CALL
        TreeNode root;
        root = TreeUtils.add(null, 50);
        root = TreeUtils.add(root, 30);
        root = TreeUtils.add(root, 40);
        root = TreeUtils.add(root, 35);
        root = TreeUtils.add(root, 37);
        // CHECK
        String expectedStr = "((()30((()35(()37()))40()))50())";
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
