package Procedure.loop._3_bubble_sort_inverted_____;
import java.lang.String;import java.lang.System;import java.util.Arrays;

//На этой странице приведен полный исходный код сортировки "пузырьком". Алгоритм допускает вариации и оптимизации.
// В данном случае приведен алгоритм, при котором "всплывает" самый большой элемент. Перепишите алгоритм на такой,
//при котором "тонет" самый маленький элемент (). Порядок сортировки должен сохраниться - по возрастанию. Элементы
// должны перебираться справа - налево. Всплывал - вправо, тонет - влево. Цикл не доходил до правого конца, теперь
// не доходит до левого.
public class bubble_sort_inverted {
    public static void main(String[] args) {
        int[][] data = {
                {},
                {1},
                {0, 3, 2, 1},
                {6, 8, 3, 5, 4, 1, 2, 0, 9, 7},
        };
        for (int[] arr : data) {
            System.out.print(Arrays.toString(arr) + " -> ");
            bubble_sort_inverted.sort(arr);
            System.out.println(Arrays.toString(arr));
        }
    }
        public static void sort(int[] arr) {

            for (int barrier =0 ; barrier <=arr.length - 1; barrier++) {

                for (int index = arr.length - 1; index > barrier; index--) {

                    if (arr[index] < arr[index - 1]) {
                        int tmp = arr[index];
                        arr[index] = arr[index - 1];
                        arr[index - 1] = tmp;
                    }

                }

            }

        }
}
