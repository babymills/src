package Procedure.loop._1_array_inverter_optimized_____;

public class ArrayInverter {
    public static void invert(int[] arr) {
        for (int k=arr.length/2-1;k>=0;k--)
//       for (int k = arr.length-1; k >=arr.length/2; k--)
        {
            int tmp = arr[k];
            arr[k] = arr[arr.length-k-1];
            arr[arr.length-k-1] = tmp;
        }
    }
}
