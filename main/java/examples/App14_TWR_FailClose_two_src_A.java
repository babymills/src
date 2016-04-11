package examples;

public class App14_TWR_FailClose_two_src_A {
        public static void main(String[] args) throws Exception {
            try (FailClose x = new FailClose("x")) {
                try (FailClose y = new FailClose("y")) {
                /*NOP*/
                }
            } catch (Error e) {
                System.err.println("catch-1");
            }
        }
    private static class FailClose implements AutoCloseable{
        private FailClose(String name) {
            this.name = name;
            System.out.println("new1:" + name);
        }

        private String name;
        @Override
        public void close() throws Exception {
            System.out.println("close1:"+ name);
            throw new Error();
        }
    }
}
