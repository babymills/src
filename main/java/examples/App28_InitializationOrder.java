package examples;

public class App28_InitializationOrder {
    public final String field;
    public static final String field2;
    {
        field="field";
        System.out.println("initialization section"+ " " + field);
    }

    static {
        field2="field2";
        System.out.println("static initialization section"+ " " + field2);
    }
    public App28_InitializationOrder() {
        System.out.println("constructor");
    }
    static void f(){
        System.out.println("f()");

    }
}
class Test{
    public static void main(String[] args) {
        App28_InitializationOrder.f();
        System.out.println("------------------");
        new App28_InitializationOrder();
        System.out.println("------------------");
        new App28_InitializationOrder();

    }
}