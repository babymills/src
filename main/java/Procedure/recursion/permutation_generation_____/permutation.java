package Procedure.recursion.permutation_generation_____;

import java.util.Arrays;

public class permutation {
    public static int count=0;
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        permute(arr, arr.length);
   //     System.out.println(count + " " + arr.length );
        System.out.println(Arrays.toString(arr));
    }
    private static void permute(int[] arr, int size) {
        if (size < 2) {
           System.out.println(Arrays.toString(arr));
            count++;
        } else {
            for (int k = 0; k < size; k++) {
                swap(arr, k, size - 1);
                permute(arr, size - 1);
                swap(arr, k, size - 1);       // возвращаем массив в исходный вид, после чего счетчик крутится на единицу
            }
        }
    }
    private static void swap(int[] arr, int index0, int index1) {
        int tmp = arr[index0];
        arr[index0] = arr[index1];
        arr[index1] = tmp;
    }
}

