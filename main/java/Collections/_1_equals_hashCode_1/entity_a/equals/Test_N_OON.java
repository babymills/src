package Collections._1_equals_hashCode_1.entity_a.equals;

import Collections._1_equals_hashCode_1.entity_a.EntityA;

public class Test_N_OON {
    public static void main(String[] args) {
        if (!new EntityA(45, 175, null).equals(new EntityA(45, 175, null))) {
            throw new AssertionError();
        }

        System.out.print("OK");
    }
}
