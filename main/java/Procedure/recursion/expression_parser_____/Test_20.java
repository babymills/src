package Procedure.recursion.expression_parser_____;

public class Test_20 {

    public static void main(String[] args) {
        if (Parser1.eval("(333-123)") != 210) {
            throw new AssertionError();
        }

        System.out.print("OK");
    }
}
