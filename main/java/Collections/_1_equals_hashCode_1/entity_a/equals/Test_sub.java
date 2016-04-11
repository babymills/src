package Collections._1_equals_hashCode_1.entity_a.equals;

import Collections._1_equals_hashCode_1.entity_a.EntityA;

public class Test_sub {

    static class EntityASubclass extends EntityA {
        public EntityASubclass(int age, int height, String name) {
            super(age, height, name);
        }
    }

    public static void main(String[] args) {
        EntityA mike0 = new EntityA(45, 175, "Mike");
        EntityA mike1 = new EntityASubclass(45, 175, "Mike");
        if (mike0.equals(mike1)) {
            throw new AssertionError();
        }

        System.out.print("OK");
    }
}
