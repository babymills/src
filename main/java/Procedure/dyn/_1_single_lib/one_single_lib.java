package Procedure.dyn._1_single_lib;

/**
 * Created with IntelliJ IDEA.
 * User: Mark
 * Date: 29.12.13
 * Time: 14:11
 * To change this template use File | Settings | File Templates.
 */
//Разработать класс-библиотеку для работы с односвязными списками. А именно 3 метода:
// public class SingleLLUtils_1 {length(Node tail) {...}max(Node tail) {...}sum(Node tail) {...}
//Используйте любой или все вместе подходы при решения задачи (итеративный, рекурсивные, в любом направлении).
public class one_single_lib {
    public static void main(String[] args) {
        Node tail = new Node(3, new Node(2, new Node(1, new Node(0, null))));

        System.out.println(Max(tail));
        System.out.println(Sum(tail));
        System.out.println(length(tail));
        lengthRec(tail);
        System.out.println(lengthRecResult);
    }

    public static int Sum(Node tail) {
        int sumResult = 0;
        while (tail != null) {
            sumResult += tail.value;
            tail = tail.next;
        }
        return sumResult;
    }
    public static int Max(Node tail) {
        int MaxResult = tail.value;
        tail=tail.next;
        while (tail!= null){
            if (MaxResult<tail.next.value) MaxResult=tail.next.value;
            tail=tail.next;
        }
        return MaxResult;
    }
    public static int length(Node tail) {
        int lengthResult = 0;
        while (tail != null) {
            lengthResult++;
            tail = tail.next;
        }
        return lengthResult;
    }
    private static int lengthRecResult=0;
    private static void lengthRec(Node tail) {
        if (tail!=null){
            lengthRecResult++;
            lengthRec(tail.next);
        }
    }
}
