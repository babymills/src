package Procedure.memory;

public class Test_0 {

    public static void main(String[] args) {
        SpiralNode tail = SpiralSolver.make(3, 3);
        print(tail);
    }

    public static void print(SpiralNode tail) {
        while (tail != null) {
            System.out.println(tail);
            tail = tail.next;
        }
    }

}
