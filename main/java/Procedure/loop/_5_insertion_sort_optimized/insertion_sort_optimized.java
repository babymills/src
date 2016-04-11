package Procedure.loop._5_insertion_sort_optimized;

import java.util.Arrays;
import java.util.Random;

/* На странице сортировки вставкой внутренний цикл while ищет позицию
для вставки перебирая последовательно элементы, при этом он поэлементно "смещает" массив.
   В целях оптимизации перепишите алгоритм:
1) осуществляйте поиск позиции для вставки бинарным поиском (Arrays.binarySearch(...))
2) найдя позицию - копируйте всю часть массива за один вызов (System.arraycopy(...))
   Примечание: пример работы с методами binarySearch(...) и arraycopy(...) вы можете посмотреть на этой странице.*/
public class insertion_sort_optimized {

    public static void main(String[] args) {
        int[][] data = {
                {},
                {1},
                {0, 3, 2, 1},
                {6, 8, 3, 123, 5, 4, 1, 2, 0, 9, 7},
        };
        for (int[] arr : data) {
            System.out.print(Arrays.toString(arr) + " -> ");
            sort(arr);
            System.out.println(Arrays.toString(arr));
        }
        Random r = new Random(47);
        int [] bigArray=new int[1_000_000];
        for (int i=0;i<bigArray.length;i++){
            bigArray[i]= r.nextInt(100);
        //    System.out.print(bigArray[i]+", ");
        }
        System.out.println();
        sort(bigArray);
        System.err.println(Arrays.toString(bigArray));
    }
    public static void sort(int[] arr) {
        for (int k = 0; k < arr.length; k++) {
            int newElement = arr[k];
            int positionToInsert;
            positionToInsert=(Arrays.binarySearch(arr,0,k,arr[k])<0)?
                    -Arrays.binarySearch(arr,0,k,arr[k])-1:
                    Arrays.binarySearch(arr,0,k,arr[k]);
            System.arraycopy(arr,positionToInsert,arr,positionToInsert+1,k-positionToInsert);
            arr[positionToInsert] = newElement;
        }
    }
}
