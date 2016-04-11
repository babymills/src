package Collections._1_equals_hashCode_1.entity_a.equals;

import Collections._1_equals_hashCode_1.entity_a.EntityA;

public class Test_same {
    public static void main(String[] args) {
        EntityA mike = new EntityA(45, 175, "Mike");
        if (!mike.equals(mike)) {
            throw new AssertionError();
        }

        System.out.print("OK");
    }
}
