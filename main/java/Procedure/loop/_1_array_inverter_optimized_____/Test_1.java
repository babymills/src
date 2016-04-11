package Procedure.loop._1_array_inverter_optimized_____;

public class Test_1 {
    public static void main(String[] args) {
        int[] array = {0};
        ArrayInverter.invert(array);
        if (array[0] != 0) {
            throw new AssertionError();
        }

        System.out.print("OK");
    }
}
