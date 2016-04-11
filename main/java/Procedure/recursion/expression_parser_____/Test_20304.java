package Procedure.recursion.expression_parser_____;

public class Test_20304 {

    public static void main(String[] args) {
        if (Parser1.eval("((333-123)*1000)/10") != 21000) {
            throw new AssertionError();
        }

        System.out.print("OK");
    }
}
