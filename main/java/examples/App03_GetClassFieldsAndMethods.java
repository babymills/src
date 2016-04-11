package examples;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

class TestClass {
    private int value;
    public int getValue() { return value; }
    public void setValue(int valueIn) { this.value = valueIn; }
}

public class App03_GetClassFieldsAndMethods {

    public static void main(String[] args) {
        TestClass testClass = new TestClass();

        for (Field field: testClass.getClass().getDeclaredFields()) {
            System.out.printf("name: %s, type: %s \n", field.getName(), field.getType().getCanonicalName());
        }

        for (Method method : testClass.getClass().getDeclaredMethods()) {
            System.out.printf("name: %s, return type: %s  \n", method.getName(), method.getReturnType().getCanonicalName());
        }
    }
}