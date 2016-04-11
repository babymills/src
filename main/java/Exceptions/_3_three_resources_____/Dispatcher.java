package Exceptions._3_three_resources_____;

public class Dispatcher {

    public static void call(AutoCloseableFactory factoryA, AutoCloseableFactory factoryB, AutoCloseableFactory factoryC, TryBody body) throws Throwable {
    //    AnswerThreeResourcesJava7.call(factoryA, factoryB, factoryC, body);
        AnswerThreeResourcesJava6.call(factoryA, factoryB, factoryC, body);
    }
}

