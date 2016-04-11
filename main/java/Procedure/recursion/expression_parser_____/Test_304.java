package Procedure.recursion.expression_parser_____;

public class Test_304 {

    public static void main(String[] args) {
        if (Parser1.eval("(11*11)/10") != 12) {
            throw new AssertionError();
        }

        System.out.print("OK");
    }
}
