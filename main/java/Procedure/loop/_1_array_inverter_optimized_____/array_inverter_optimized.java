package Procedure.loop._1_array_inverter_optimized_____;

import java.util.Arrays;
//Задание состоит в том, что бы переписать инкремент счетчика цикла на декремент с нижним пределом 0
// в примере метода, инвертирующего массив.

public class array_inverter_optimized {

    public static void main(String[] args) {
//        int []array= {0,1,2,3,4,5,6};
//        System.out.print(Arrays.toString(array));
//        invert(array);
//        System.out.print(Arrays.toString(array));
    }
    public static void invert(int[] arr)
    {
        for (int k=arr.length/2-1;k>=0;k--)
//       for (int k = arr.length-1; k >=arr.length/2; k--)
        {
            int tmp = arr[k];
            arr[k] = arr[arr.length-k-1];
            arr[arr.length-k-1] = tmp;
        }
    }
}