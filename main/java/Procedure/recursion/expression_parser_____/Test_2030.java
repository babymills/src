package Procedure.recursion.expression_parser_____;

public class Test_2030 {

    public static void main(String[] args) {
        if (Parser1.eval("((333-123)*1000)") != 210000) {
            throw new AssertionError();
        }

        System.out.print("OK");
    }
}
