package Procedure.memory;

public class gc_dying {
    public static void main(String[] args) {
        Object ref = null;
        for (int k = 0; k < Integer.MAX_VALUE; k++) {
            System.out.println(k);
            ref = new Object[] {ref, new int[1_000_000]};
        }
    }
}
