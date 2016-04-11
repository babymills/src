package Collections._1_equals_hashCode_1.entity_a.equals;

import Collections._1_equals_hashCode_1.entity_a.EntityA;

public class Test_XOO {
    public static void main(String[] args) {
        if (new EntityA(45, 175, "Mike").equals(new EntityA(25, 175, "Mike"))) {
            throw new AssertionError();
        }

        System.out.print("OK");
    }
}
