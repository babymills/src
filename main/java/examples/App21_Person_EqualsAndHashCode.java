package examples;
import java.util.*;

public class App21_Person_EqualsAndHashCode {

    public static void main(String[] args) {
        Set<Person> set = new HashSet<>();
        set.add(new Person("Mark", 20));
        set.add(new Person("Anna", 22));
        set.add(new Person("Vanya", 19));
        System.out.println(set);

        System.out.println("contains ? " + set.contains(new Person("Mark", 20)));
        System.out.println("remove ? " + set.remove(new Person("Mark", 20)));

        System.out.println(set);
    }

    public static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "{ name='" + name + '\'' +", age=" + age +"}";
        }

        @Override
        public int hashCode() {
            return 31*age + name.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (this==obj) return true;
            if (obj==null || obj.getClass()!= Person.class) return false;

            Person that = (Person) obj;
            return this.age==that.age && this.name.equals(that.name);
        }
    }
}