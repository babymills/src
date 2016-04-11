package Procedure.loop.matrix_mul;
import java.util.Arrays;
//  Напишите метод, умножающий две 2-мерные квадратные матрицы.
public class MatrixUtils {
    public static void main(String[] args) {
//        int[][] a ={
//                {1, 2, 3},
//                {4, 5},
//                {7, 8, 9}};
//        int[][] b = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}};
//        System.out.println(Arrays.deepToString(mul(a, b)));
    }
    public static int[][] mul(int[][] leftArray, int[][] rightArray){
          try{
            int sizeOfLeftArray=0;
            int sizeOfRightArray=0;
              // Если одна из матриц null - получаю NullPointerException
            int initialSizeOfLeftArray=leftArray.length*leftArray[0].length;
            int initialSizeOfRightArray=rightArray.length*rightArray[0].length;
              // Считаем количество элементов в первой матрице
            for (int i = 0; i <leftArray.length; i++)
                for (int j = 0; j <leftArray[i].length; j++){
                    sizeOfLeftArray++;
                }
            // System.err.println(sizeOfLeftArray);
              // Считаем количество элементов во второй матрице
            for (int i = 0; i <rightArray.length; i++)
                for (int j = 0; j <rightArray[i].length; j++){
                    sizeOfRightArray++;
                }
            // System.err.println(sizeOfRightArray);
              // Если количество элементов в какой-то из матриц не совпадает с требуемым
            if ((sizeOfLeftArray!=initialSizeOfLeftArray) || (sizeOfRightArray!=initialSizeOfRightArray)) {
                throw new IllegalArgumentException();
            }
             // Если матрицы не подходят для перемножения
            else if (leftArray[0].length!=rightArray.length ){
                throw new IllegalArgumentException();
            }
            else {
                    int [][] result=new int [leftArray.length][rightArray[0].length];
                    for (int i = 0; i <leftArray.length; i++)
                        for (int j = 0; j <rightArray[0].length; j++)
                        {
                            result[i][j]= 0;
                            for (int k = 0; k <rightArray.length; k++)
                            {
                                result[i][j] += leftArray[i][k] * rightArray[k][j];
                            }
                        }
                    return result;
                }
          }
          catch (NullPointerException  e){
              throw new IllegalArgumentException(e);
          }
    }
}



