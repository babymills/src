package Procedure.dyn._2_single_lib;

import Procedure.dyn._4_double_lib.NoSuchPositionException;

import static Procedure.dyn._2_single_lib.Test.Node.*;

//Разработать класс-библиотеку для работы с односвязными списками. А именно 4 метода из DynamicArray:
//public class SingleLLUtils_2 {
//    public static Node add(Node tail, int elem) {...}
//    public static Node remove(Node tail) {...}
//    public static Node add(Node tail, int index, int elem) {...}
//    public static Node remove(Node tail, int index) {...}
//Используйте любой или все вместе подходы при решения задачи (итеративный, рекурсивные, в любом направлении).
public class Test {
    public static void main(String[] args) {
        Node tail = _(3, 2, 1, 0);
        System.out.println("original: " +tail);
        System.out.println("add last: " + addLast(tail, -100));
        System.out.println("add index: " +insertInPosition(tail, 1, -100));
        System.out.println("remove last: " +removeLast(tail));
        System.out.println("remove index: " +removeInPosition(tail, 1));
    }
    static class Node{
        public int value;
        public Node next;
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            Node node = this;
            String result = "";
            while (node != null) {
                result += node.value + "->";
                node = node.next;
            }
            return result + "*";
        }

        public static Node _(int... values) {
            Node tail = null;
            for (int k = values.length - 1; k >= 0; k--) {
                tail = new Node(values[k], tail);
            }
            return tail;
        }

        public static Node addLast(Node tail, int elem){
            if (tail==null) return new Node(elem,null);
            else {
                Node helpernode=tail;

                while (tail.next!=null)tail=tail.next;

                tail.next= new Node(elem,null);
                return helpernode;
            }
        }

        public static Node removeLast(Node tail) {
            if (tail.next==null) return null;
            else {
                Node helpernode=tail;
                while (tail.next.next!=null)tail=tail.next;
                tail.next= null;
                return helpernode;
            }
        }

        public static Node insertInPosition(Node tail, int index, int elem) {
            if (index < 0) throw new IllegalArgumentException("index must be positive");
            if (tail==null) throw  new NullPointerException("null parameter passed to a method");

            // if we want element to be the first one
            if (index==0) {
                return new Node(elem,tail);
            }
            else{
                Node startOfNode = tail;
                // if we add element between the others
                while (--index > 0 && tail.next!=null ){
                    tail=tail.next;
                }

                if (index>1 && tail.next==null) throw  new NoSuchPositionException("size of DoubleNode is less then passed index");

                while (--index>0){
                    tail=tail.next;
                    index--;
                }
                tail.next= new Node(elem,tail.next);
                return startOfNode;
            }
        }

        public static Node removeInPosition(Node tail, int index) {

            if (index < 0) throw new IllegalArgumentException("index must be positive");
            if (tail==null) throw  new NullPointerException("null parameter passed to a method");

            // if we removing the first one
            if (index==0) {
                return tail.next;
            }

            Node startOfNode = tail;

            while (--index > 0 && tail.next.next!=null){
                tail=tail.next;
            }

            if (index>0 && tail.next.next==null) throw new NoSuchPositionException("size of Node is less then passed index");

            //if we removing the last one
            if (tail.next.next == null){
                tail.next=null;
            } else {
                // if we removing between the nodes
                tail.next=tail.next.next;
            }
            return startOfNode;
        }
}
}
