package Procedure.recursion.expression_parser_____;

import static java.lang.Character.isDigit;
import static java.lang.Integer.valueOf;

public class Parser1 {

    public static int eval(String expr) {
        if (expr.startsWith("(") && expr.endsWith(")")) {
            return eval(expr.substring(1, expr.length() - 1));
        } else if (expr.startsWith("(") && !expr.endsWith(")")) {
            throw new RuntimeException("If expr start with '(' than MUST end with ')' but expr = '" + expr + "'");
        } else {
            int pos = 0;
            while (pos < expr.length() - 1) {
                if (isDigit(expr.charAt(pos))) {
                    pos++;
                } else {
                    int leftOperand = Integer.valueOf(expr.substring(0, pos));
                    char operation = expr.charAt(pos);
                    int rightOperand = eval(expr.substring(pos + 1));
                    switch (operation) {
                        case '+': return leftOperand + rightOperand;
                        case '-': return leftOperand - rightOperand;
                        case '*': return leftOperand * rightOperand;
                        case '/': return leftOperand / rightOperand;
                    }
                }
            }
            return valueOf(expr);
        }
    }
}
