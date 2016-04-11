package examples;

import java.util.*;
public class App16_Person_Comparable_TreeSet {

    public static void main(String[] args) {
        Set<Person>  set = new TreeSet<>();
        set.add(new Person("Mark", 20));
        set.add(new Person("Anna", 22));
        set.add(new Person("Vanya", 19));
        System.out.println(set.size());
        System.out.println(set);
        System.out.println(set.add(new Person("Vanya", 19)));
    }

    public static class Person implements Comparable<Person>{
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(Person obj) {
            if (this==obj) return 0;
            if (obj==null) throw new NullPointerException();
            if (obj.getClass() != Person.class) throw new ClassCastException();

            Person that = (Person) obj;
            int ageComparison = this.age - that.age;
            return (ageComparison!=0) ? ageComparison : this.name.compareTo(that.name);
        }

        @Override
        public String toString() {
            return "{ name='" + name + '\'' +", age=" + age +"}";
        }
    }

                     }
