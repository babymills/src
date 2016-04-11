package Exceptions._2_two_resources_____;

public class AnswerTwoResourcesJava7 {
    public static void call(
            AutoCloseableFactory factoryA,
            AutoCloseableFactory factoryB,
            TryBody body) throws Throwable {

        try (AutoCloseable a = factoryA.create();
             AutoCloseable b = factoryB.create()) {
            body.runBody();
        }
    }
}