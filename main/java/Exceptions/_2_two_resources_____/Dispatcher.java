package Exceptions._2_two_resources_____;

public class Dispatcher {
    public static void call(AutoCloseableFactory factoryA, AutoCloseableFactory factoryB, TryBody body) throws Throwable {
//        AnswerTwoResourcesJava7.call(factoryA, factoryB, body);
        AnswerTwoResourcesJava6.call(factoryA, factoryB, body);
    }
}