package Procedure.recursion.expression_parser_____;

//TODO: Сделать парсер
public class parser {

    public static void main(String[] args) {
        //   Тестирующий код (для моего примера)
//        System.out.println(eval("123"));
//        System.out.println(eval("2*3"));
//        System.out.println(eval("2*(1+3)"));
//        System.out.println(eval("1+(5-2*(13/6))"));
        //  Тестирующий код (для вашего решения)
        System.out.println(">> 123 = " + parser.eval("123"));
        System.out.println(">> 2*3 = " + parser.eval("2*3"));
        System.out.println(">> (1+3)*2 = " + parser.eval("(1+3)*2"));
        System.out.println(">> ((13/6)*2-5)+1 = " + parser.eval("((13/6)*2-5)+1"));
    }

    private static int eval(String expr) {
        return eval(expr, 0, expr.length());

    }

    private static int eval(String expr, int from, int to) {
        int countSigns =0;

        if (expr.charAt(from) == '('){
            countSigns=1;
            int count=from;
            while (countSigns!=0) {
                  if (expr.charAt(from) == '('){
                   countSigns++;
                    }
                   else if (expr.charAt(from) == ')'){
                   countSigns--;
                    }
                count++;
             }
            return eval(expr,from+1,count+1);
        }
            int pos = from;
            while (pos < to) {
                if (Character.isDigit(expr.charAt(pos))) {
                    pos++;
                } else {
                    int leftOperand = Integer.valueOf(expr.substring(from, pos));
                    char operation = expr.charAt(pos);
                    int rightOperand = eval(expr, pos + 1, to);
                    switch (operation) {
                        case '+':
                            return leftOperand + rightOperand;
                        case '-':
                            return leftOperand - rightOperand;
                        case '*':
                            return leftOperand * rightOperand;
                        case '/':
                            return leftOperand / rightOperand;
                    }
                }
            }
            return Integer.valueOf(expr.substring(from, to));
        }
    }
