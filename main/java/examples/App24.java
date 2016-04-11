package examples;

import java.util.Set;
import java.util.TreeSet;


public class App24 {

    public static void main(String[] args) {
        Set<Integer>  set = new TreeSet<>();
        set.add(21);
        set.add(22);
        set.add(23);
        System.out.println(set.size());
        System.out.println(set);
    }
}
