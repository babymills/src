package Procedure.dyn._5_fibonacci_tree;

// Разработать класс-библиотеку для генерации бинарного дерева,
// соответствующего по форме истории рекурсивного вычисления числа Фибоначчи. А именно 2 метода.
//generateArg() - в качестве value ставит номер числа Фибоначчи (аргумент, по которому вычисляют число Фибоначчи)
//generateRes() - в качестве value ставит значение числа Фибоначчи

public class five_fibonacci_tree {
    public static void main(String[] args) {
        print(generateArg(3), 0);
        System.out.println("-------");
        print(generateRes(5), 0);
    }
    public static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    public static int fib(int arg) {
        return arg < 2 ? 1 : fib(arg - 2) + fib(arg - 1);
    }

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

        private static void print(TreeNode root, int depth) {
            if (root != null) {
                print(root.right, depth + 1);
                for (int k = 0; k < depth; k++) {
                    System.out.print("   ");
                }
                System.out.println(root.value);
                print(root.left, depth + 1);
            }
        }
}
