package Procedure.recursion.expression_parser_____;

public class Test_40 {

    public static void main(String[] args) {
        if (Parser1.eval("(159/15)") != 10) {
            throw new AssertionError();
        }

        System.out.print("OK");
    }
}
