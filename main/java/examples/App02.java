package examples;
import java.util.*;
public class App02 {
    public static void main(String[] args) {
        // Создание объекта по шаблону.
        List<String> strings = new LinkedList<String>();
        strings.add("Hello");
        strings.add("world");
        strings.add("!");
        for (String s : strings) {
            System.out.print(s + " ");
        }
    }
}