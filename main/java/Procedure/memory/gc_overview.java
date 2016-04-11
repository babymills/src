package Procedure.memory;

public class gc_overview {
        public static void main(String[] args) {
            for (int k = 0; k < Integer.MAX_VALUE; k++) {
                System.out.println(k);
                Object ref = new byte[1_000_000];
            }
        }
}