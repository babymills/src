package examples;

public class App00_ExceptWithReturn {
        public static void main(String[] args) {
            System.err.println(f());
        }
        public static int f() {
            try {
                throw new Error();
            } finally {
                return 1;
            }
        }
    }

