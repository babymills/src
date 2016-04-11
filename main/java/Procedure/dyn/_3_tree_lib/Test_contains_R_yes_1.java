package Procedure.dyn._3_tree_lib;

public class Test_contains_R_yes_1 {
    public static void main(String[] args) {
        // PREPARE
        TreeNode root = _(20, _(30));
        // CALL + CHECK
        if (!TreeUtils.contains(root, 30)) {
            throw new AssertionError();
        }

        System.out.print("OK");
    }

    public static TreeNode _(int value, TreeNode right) {
        return new TreeNode(value, null, right);
    }

    public static TreeNode _(int value) {
        return new TreeNode(value, null, null);
    }
}
