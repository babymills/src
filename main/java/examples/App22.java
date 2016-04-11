package examples;

import java.util.HashSet;
import java.util.Set;

public class App22 {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(19);
        set.add(20);
        set.add(21);
        System.out.println(set);

        System.out.println("contains ? " + set.contains(20));
        System.out.println("remove ? " + set.remove(20));

        System.out.println(set);
    }
}