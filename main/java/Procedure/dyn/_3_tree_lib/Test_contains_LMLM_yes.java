package Procedure.dyn._3_tree_lib;

public class Test_contains_LMLM_yes {
    public static void main(String[] args) {
        // PREPARE
        TreeNode root = _(_(30, _(_(35, _(37)), 40)), 50);
        // CALL + CHECK
        if (!TreeUtils.contains(root, 37)) {
            throw new AssertionError();
        }

        System.out.print("OK");
    }

    public static TreeNode _(TreeNode left, int value, TreeNode right) {
        return new TreeNode(value, left, right);
    }

    public static TreeNode _(int value, TreeNode right) {
        return new TreeNode(value, null, right);
    }

    public static TreeNode _(TreeNode left, int value) {
        return new TreeNode(value, left, null);
    }

    public static TreeNode _(int value) {
        return new TreeNode(value, null, null);
    }
}
