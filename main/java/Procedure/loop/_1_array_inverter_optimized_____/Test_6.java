package Procedure.loop._1_array_inverter_optimized_____;

public class Test_6 {
    public static void main(String[] args) {
        int[] array = {5, 4, 3, 2, 1, 0};
        ArrayInverter.invert(array);
        if (array[0] != 0
         || array[1] != 1
         || array[2] != 2
         || array[3] != 3
         || array[4] != 4
         || array[5] != 5) {
            throw new AssertionError();
        }

        System.out.print("OK");
    }
}
