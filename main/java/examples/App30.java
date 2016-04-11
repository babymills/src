package examples;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App30 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<String>() {
            {
                add("Hello");
                add("world");
            }
        };
        System.out.println(stringList);

        List<Integer> list1 = new ArrayList<Integer>();
        ArrayList list2 = new ArrayList();
        Method[] methods1 = list1.getClass().getMethods();
        System.out.println(methods1.length);
        System.out.println(Arrays.toString(methods1));
        Method[] methods2 = list2.getClass().getMethods();
        System.out.println(methods2.length);
        System.out.println(Arrays.toString(methods2));

        A a = new B();
        B b = new B();
        a.m1();
        a.m2();
        b.m1();
        b.m2();
        b.m3();
        System.out.println(Arrays.toString(a.getClass().getMethods()));
        System.out.println(Arrays.toString(b.getClass().getMethods()));
        System.out.println(Arrays.toString(b.getClass().getDeclaredMethods()));
        System.out.println(a.fieldA);
        System.out.println(b.fieldA);
        System.out.println(b.fieldB);
        System.out.println(Arrays.toString(a.getClass().getDeclaredFields()));
        System.out.println(Arrays.toString(b.getClass().getDeclaredFields()));
    }


}

