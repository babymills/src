package Procedure.recursion.expression_parser_____;

public class Test_401 {

    public static void main(String[] args) {
        if (Parser1.eval("(159/15)+11") != 21) {
            throw new AssertionError();
        }

        System.out.print("OK");
    }
}
