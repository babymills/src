package Procedure.dyn._3_tree_lib;

public class Test_contains_1_yes {
    public static void main(String[] args) {
        // PREPARE
        TreeNode root = _(10);
        // CALL + CHECK
        if (!TreeUtils.contains(root, 10)) {
            throw new AssertionError();
        }

        System.out.print("OK");
    }

    public static TreeNode _(int value) {
        return new TreeNode(value, null, null);
    }
}
