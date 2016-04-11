package examples;


public class App04 {
        public static void main(String[] args) throws Error {
            try {
                throw new Exception();
            } catch (Error t) {
                // nothing
            } catch (Exception e) {

            }
        }
    }
