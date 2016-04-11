package Procedure.loop._1_array_inverter_optimized_____;

public class Test_2 {
    public static void main(String[] args) {
        int[] array = {1, 0};
        ArrayInverter.invert(array);
        if (array[0] != 0 && array[1] != 1) {
            throw new AssertionError();
        }

        System.out.print("OK");
    }
}
