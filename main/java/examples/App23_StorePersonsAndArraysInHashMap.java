package examples;

import java.util.*;

public class App23_StorePersonsAndArraysInHashMap {

    public static void main(String[] args) {
/*
        Map<Person,int[]> map = new HashMap<>();
        map.put(new Person("Mark", 20), new int[]{2000, 3000, 7000});
        map.put(new Person("Anna", 20), new int[]{2000, 2500, 3500});
        map.put(new Person("Vanya", 20), new int[]{1000, 2000, 3000});

        System.out.println(map.size());
        for (Map.Entry<Person, int[]> personEntry : map.entrySet()) {
            System.out.println(personEntry.getKey().toString() + " = " + Arrays.toString(personEntry.getValue()));
        }

        System.out.println(map.containsKey(new Person("Anna", 20)));
        System.out.println(map.containsValue(new Integer[]{1000, 2000, 3000}));

        System.out.println(Arrays.toString(map.remove(new Person("Anna", 20))));
*/

        Map<Person,List<Integer>> map = new HashMap<>();
        map.put(new Person("Mark", 20), Arrays.asList(2000, 3000, 7000));
        map.put(new Person("Anna", 20), Arrays.asList(2000, 2500, 3500));
        map.put(new Person("Vanya", 20),Arrays.asList(1000, 2000, 3000));

        System.out.println(map.size());
        for (Map.Entry<Person, List<Integer>> personEntry : map.entrySet()) {
            System.out.println(personEntry.getKey().toString() + " = " + personEntry.getValue());
        }

        System.out.println(map.containsKey(new Person("Anna", 20)));
        System.out.println(map.containsValue(Arrays.asList(1000,2000,3000)));

        System.out.println(map.remove(new Person("Anna", 20)));

    }

    public static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
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

        @Override
        public String toString() {
            return "{ name='" + name + '\'' +", age=" + age +"}";
        }
    }
}
