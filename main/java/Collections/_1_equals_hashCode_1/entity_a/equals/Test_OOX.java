package Collections._1_equals_hashCode_1.entity_a.equals;

import Collections._1_equals_hashCode_1.entity_a.EntityA;

public class Test_OOX {
    public static void main(String[] args) {
        if (new EntityA(45, 175, "Mike").equals(new EntityA(45, 175, "Anna"))) {
            throw new AssertionError();
        }

        System.out.print("OK");
    }
}
