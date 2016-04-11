package Procedure.loop._5_insertion_sort_optimized;

import java.util.Arrays;

public class InsertionSorter {

    public static void sort(int[] arr) {
        for (int k = 0; k < arr.length; k++) {
            int newElement = arr[k];
            int positionToInsert;
            positionToInsert=(Arrays.binarySearch(arr, 0, k, arr[k])<0)?
                    -Arrays.binarySearch(arr,0,k,arr[k])-1:
                    Arrays.binarySearch(arr,0,k,arr[k]);
            System.arraycopy(arr,positionToInsert,arr,positionToInsert+1,k-positionToInsert);
            arr[positionToInsert] = newElement;
    }
}
}
