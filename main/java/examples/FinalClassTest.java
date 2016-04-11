package examples;

/**
 * @author Mark created at: 24.06.14, 15:02
 */
public final class FinalClassTest {
    public FinalClassTest() {
        super();
    }
}
class  TestFinal{
    public static void main(String[] args) {
        // I can init multiple times this class
        FinalClassTest finalClass1 = new FinalClassTest();
        FinalClassTest finalClass2 = new FinalClassTest();
        System.out.println(finalClass1.hashCode());
        System.out.println(finalClass2.hashCode());
    }
}

class ChildFinal /*extends FinalClassTest*/{
    // but i could not extend it
}