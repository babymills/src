package Procedure.dyn._3_tree_lib;

public class Test_add_MLML {
    public static void main(String[] args) {
        // CALL
        TreeNode root;
        root = TreeUtils.add(null, 50);
        root = TreeUtils.add(root, 70);
        root = TreeUtils.add(root, 60);
        root = TreeUtils.add(root, 65);
        root = TreeUtils.add(root, 62);
        // CHECK
        String expectedStr = "(()50((()60((()62())65()))70()))";
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
