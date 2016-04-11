package examples;

/*А что будет если вместо String variable = null; написать просто String variable; ??
Такой код, заставляет думать, и он явно показывает как тот кто отвечает ориентируется,
 в данном случае, в полиморфизме и выделении памяти в JVM. */
public class habrInitExample {
    String variable;
    public static void main(String[] args) {
        System.out.println("Hello World!");
        C b = new C();
    }

    public habrInitExample(){
        printVariable();
    }

    protected void printVariable(){
        variable = "variable is initialized in Main Class";
    }
}

class C extends habrInitExample {
    String variable = null;

    public C(){
        System.out.println("variable value = " + variable);
    }

    protected void printVariable(){
        variable = "variable is initialized in B Class";
    }
}
