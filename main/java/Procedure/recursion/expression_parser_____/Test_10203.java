package Procedure.recursion.expression_parser_____;

public class Test_10203 {

    public static void main(String[] args) {
        if (Parser1.eval("((123+321)-1)*2") != 886) {
            throw new AssertionError();
        }

        System.out.print("OK");
    }
}
