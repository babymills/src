package examples;

public class App15_TWR_FailClose_two_src_B {
    public static void main(String[] args) throws Exception {
        try (FailClose x = new FailClose("x")) {
            try (FailClose y = new FailClose("y")) {
                /*NOP*/
            } finally {
                System.err.println("finally-0");
            }
        } catch (Error e) {
            System.err.println("catch-1");
        }
    }
}
