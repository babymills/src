package Procedure.dyn._3_tree_lib;

public class Test_contains_L_no_0 {
    public static void main(String[] args) {
        // PREPARE
        TreeNode root = _(_(10), 20);
        // CALL + CHECK
        if (TreeUtils.contains(root, 15)) {
            throw new AssertionError();
        }

        System.out.print("OK");
    }

    public static TreeNode _(TreeNode left, int value) {
        return new TreeNode(value, left, null);
    }

    public static TreeNode _(int value) {
        return new TreeNode(value, null, null);
    }
}
