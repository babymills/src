package Exceptions._3_three_resources_____;

public class AnswerThreeResourcesJava7 {
    public static void call(
            AutoCloseableFactory factoryA,
            AutoCloseableFactory factoryB,
            AutoCloseableFactory factoryC,
            TryBody body) throws Throwable {

        try (AutoCloseable a = factoryA.create();
             AutoCloseable b = factoryB.create();
             AutoCloseable c = factoryC.create()
        ) {
            body.runBody();
        }
    }
}

