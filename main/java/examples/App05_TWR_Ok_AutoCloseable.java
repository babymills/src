package examples;


public class App05_TWR_Ok_AutoCloseable {
    public static void main(String[] args) {
        try (Ok x = new Ok("x")) {
            System.err.println("body");
    }
    }

    public static class Ok implements AutoCloseable {
        private String msg;
        public Ok(String msg) {
            this.msg = msg;
            System.err.println("new:" + msg);
        }
        public void close() {
            System.err.println("close:" + msg);
        }
    }
}
