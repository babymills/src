package Procedure.dyn._3_tree_lib;

//Разработать класс-библиотеку для работы с бинарными деревьями. А именно 4 метода.
//Примечание: почти так и устроен java.util.TreeMap. Добавляется поддержка "сбалансированности":
//в отличии от нашего дерева, TreeMap не вырождается в односвязный список (структура данных TreeMap
//называется Красно-Черное дерево).
//TODO: lab3
public class three_tree_lib {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(3,
           new TreeNode(1, null,null),new TreeNode(4, null,null)),
                new TreeNode(9,
             new TreeNode(6, null,null),null));
  //      System.out.println("height " +height(root));
        System.out.println("sum " + sum(root));
        System.out.println("size " + size(root));
        System.out.println("max " + max(root));

    }
/*    public static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }*/

    public static int size(TreeNode root) {
        return (root==null)? 0: size(root.left)+1+size(root.right);
    }
    // TODO: method height
    public static int height = 0;
    public static int height(TreeNode root) {
        if (root!=null){
            height++;
            if (root.left!=null && root.right!=null){
                height++;
                height(root.left);
                height(root.right);
            } else if (root.left!=null){
                height++;
                height(root.left);
            } else if (root.right!=null){
                height++;
                height(root.right);
            }
        }
/*
        if (root==null){
            height=Math.max()
        }*/
        if (root!=null)
        while (root.left!=null && root.right!=null){

        }
        return height;
}

    public static int sum(TreeNode root) {
        return (root==null)? 0: sum(root.left)+root.value+sum(root.right);
    }

    public static int max(TreeNode root) {
        return (root.right!=null)? max(root.right):root.value;
    }
}
