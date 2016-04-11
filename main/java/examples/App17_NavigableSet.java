package examples;

import java.util.NavigableSet;
import java.util.TreeSet;

public class App17_NavigableSet {
        public static void main(String[] args) {
            NavigableSet<String> set = new TreeSet<>();
            set.add("A");
            set.add("AB");
            set.add("B");
            set.add("A");
            set.add("BA");
            set.add("B");
            System.out.println(set);
            System.out.println(set.headSet("ABC", true));
            System.out.println(set.headSet("ABC", true).size());
            System.out.println(set.ceiling("BB"));

        }
}