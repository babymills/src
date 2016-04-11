package Procedure.loop._2_array_merger_fixed_____;

import java.util.Arrays;

//Метод Merger.merge(...) реализован с небольшой ошибкой - он корректно сливает, но некорректно обрабатывает ситуацию,
// когда один из массивов полностью выбран.
//1. Исправьте ошибку. 2. После того как обнаружится, что один из массивов "исчерпан"
// копируйте данные со второго не в цикле, а одним вызовом System.arraycopy(...).
public class array_merger_fixed {
    public static void main(String[] args) {
        int [] arr0={0,2,4,6,8,10,11,12,13,14};
        int [] arr1={1,3,5,7,9,11,12};
        System.out.println(Arrays.toString(array_merger_fixed.merge(arr0,arr1))) ;
    }
    public static int[] merge(int[] a, int[] b) {
            int[] result = new int[a.length + b.length];
            int aIndex = 0;
            int bIndex = 0;
        while ((aIndex!=a.length) && (b.length!=bIndex)) {
//            if (a[aIndex] < b[bIndex]) {
//                result[aIndex + bIndex] = a[aIndex++];
//            } else {
//                result[aIndex + bIndex] = b[bIndex++];
//            }
            result[aIndex + bIndex]=(a[aIndex] < b[bIndex])? a[aIndex++]:b[bIndex++];
        }
       if (aIndex==a.length) System.arraycopy(b,bIndex,result,aIndex+bIndex,b.length-bIndex);
           else System.arraycopy(a,aIndex,result,aIndex+bIndex,a.length-aIndex);
       return result;

//                    while (aIndex + bIndex != result.length) {
//                if (a.length==aIndex)
//                {
//                    System.arraycopy(b,bIndex,result,aIndex+bIndex,b.length-bIndex);
//                    return result;
//                }
//                else if (b.length==bIndex)
//                {
//                    System.arraycopy(a,aIndex,result,aIndex+bIndex,a.length-aIndex);
//                    return result;
//                }  else
//                if (a[aIndex] < b[bIndex]) {
//                    result[aIndex + bIndex] = a[aIndex++];
//                } else {
//                    result[aIndex + bIndex] = b[bIndex++];
//                }
//            }
//            return result;
       }
    }

