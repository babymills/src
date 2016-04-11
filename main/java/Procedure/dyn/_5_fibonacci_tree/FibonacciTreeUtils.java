package Procedure.dyn._5_fibonacci_tree;

public class FibonacciTreeUtils {

    public static TreeNode generateArg(int k) {
        if (k<2) {
            return (k==1) ? new TreeNode(k,null,null): new TreeNode(k,null,null);
        }
        else return new TreeNode(k,generateArg(k-2),generateArg(k-1));
    }

    public static TreeNode generateRes(int k) {
        if (k<2) {
            return new TreeNode(1,null,null);
        }
        else return new TreeNode(generateRes(k-2).value + generateRes(k-1).value,generateRes(k-2),generateRes(k-1));
    }
}
