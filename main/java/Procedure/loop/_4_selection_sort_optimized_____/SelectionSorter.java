package Procedure.loop._4_selection_sort_optimized_____;

/**
 * Optimized (speed) answer: use local var - not array access
 */
public class SelectionSorter {
    public static void sort(int[] arr) {
        int count=0;
        for (int barrier = 0; barrier < arr.length - 1; barrier++) {
            int currentElement=arr[barrier];       // берем новый элемент
            int indexOfLeastElem=barrier;          // обновляем счетчик наименьшего элемента
            for (int index = barrier + 1; index < arr.length; index++) {
                if (currentElement > arr[index]) { // если наш элемент больше следующего за ним, то
                    indexOfLeastElem=index;        // запоминаем индекс следующего и теперь будем
                    currentElement=arr[index];     // сравнивать следующий элемент с остальными за ним
                                                   // тоесть вопрос: "наименьший ли он среди всех ?"
                }
            }
            arr[indexOfLeastElem]=arr[barrier];    // если взятый элемент и есть самый маленький, то переприсваем
                                                   // ему значение ИЛИ присваиваем ему значение наименьшего элемента
            arr[barrier]=currentElement;           // а тому значение наименьшего элемента, который нашли
        }
    }
}
