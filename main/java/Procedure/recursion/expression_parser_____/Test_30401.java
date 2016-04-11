package Procedure.recursion.expression_parser_____;

public class Test_30401 {

    public static void main(String[] args) {
        if (Parser1.eval("((11*11)/10)+123") != 135) {
            throw new AssertionError();
        }

        System.out.print("OK");
    }
}
