package Procedure.recursion.expression_parser_____;

public class Test_40102 {

    public static void main(String[] args) {
        if (Parser1.eval("((159/15)+11)-1") != 20) {
            throw new AssertionError();
        }

        System.out.print("OK");
    }
}
