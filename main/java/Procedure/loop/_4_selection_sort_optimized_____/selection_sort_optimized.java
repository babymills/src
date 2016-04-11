package Procedure.loop._4_selection_sort_optimized_____;
import java.util.Arrays;

//Есть гипотеза, что обращение к локальной переменной типа int происходит быстрее чем обращение
// к элементу локальной переменной типа int[].
//   Задание состоит в том, что бы переписать алгоритм Selection Sort:
// - убрать обращение во внутреннем цикле к элементу массива arr[barrier]
// - убрать обмен элементами arr[barrier] c arr[index] каждый раз, когда находится очередной меньший элемент.
// Найти наименьший элемент - обменять с ним.
public class selection_sort_optimized {
    public static void main(String[] args) {
        int[][] data = {
                {},
                {1},
                {2, 1},
                {4, 6, 2},
                {0, 3, 2, 1},
                {6, 8, 3, 100, 5, 4, 1, 2, 0, 9, 7},
        };
        for (int[] arr : data) {
            System.out.print(Arrays.toString(arr) + "-->");
            SelectionSort.mySort(arr);
            System.out.println(Arrays.toString(arr));
        }
    }

    private static class SelectionSort {
        public static void Sort(int[] arr) {
            int indexOfLeastElem;
            int count=0;
            for (int barrier = 0; barrier < arr.length - 1; barrier++) {
                for (int index = barrier + 1; index < arr.length; index++) {
                    if (arr[barrier] > arr[index]) {
                        int tmp = arr[index];
                        arr[index] = arr[barrier];
                        arr[barrier] = tmp;
                        System.out.print("обмен ");
                        count++;
                    }
                    System.out.print(barrier+ " "+index+"\n");
                }
            }
            System.out.println("count " + count);
        }

        public static void mySort(int[]arr) {
            int count=0;     // просто подсчитуем количество раз, которое выполнился if
            for (int barrier = 0; barrier < arr.length - 1; barrier++) {
                int currentElement=arr[barrier];       // берем новый элемент
                int indexOfLeastElem=barrier;          // обновляем счетчик наименьшего элемента
            for (int index = barrier + 1; index < arr.length; index++) {
                if (currentElement > arr[index]) { // если наш элемент больше следующего за ним, то
                    indexOfLeastElem=index;        // запоминаем индекс следующего и теперь будем
                    currentElement=arr[index];     // сравнивать следующий элемент с остальными за ним
                    count++;// тоесть вопрос: "наименьший ли он среди всех ?"
                }
            }
            arr[indexOfLeastElem]=arr[barrier];    // если взятый элемент и есть самый маленький, то переприсваем
                                                 // ему значение ИЛИ присваиваем ему значение наименьшего элемента
            arr[barrier]=currentElement;          // а тому значение наименьшего элемента, который нашли
            }
            System.out.println("\n count " + count);
        }
    }
}



