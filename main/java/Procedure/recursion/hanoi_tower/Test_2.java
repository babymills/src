package Procedure.recursion.hanoi_tower;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Test_2 {
    public static void main(String[] args) {
        // PREPARE
        final List<String> actualHistory = new ArrayList<>();
        Stack from = new Stack() {
            public void push(int value) {
                actualHistory.add("from.push(" + value + ")");
                super.push(value);
            }
            public int pop() {
                actualHistory.add("from.pop()");
                return super.pop();
            }
        };
        Stack help = new Stack() {
            public void push(int value) {
                actualHistory.add("help.push(" + value + ")");
                super.push(value);
            }
            public int pop() {
                actualHistory.add("help.pop()");
                return super.pop();
            }
        };
        Stack to = new Stack() {
            public void push(int value) {
                actualHistory.add("to.push(" + value + ")");
                super.push(value);
            }
            public int pop() {
                actualHistory.add("to.pop()");
                return super.pop();
            }
        };
        from.push(2);
        from.push(1);

        // CALL
        HanoiSolver.solve(from, help, to, 2);

        // CHECK
        List<String> expectedHistory = asList(
                "from.push(2)", "from.push(1)",
                "from.pop()", "help.push(1)",
                "from.pop()", "to.push(2)",
                "help.pop()", "to.push(1)"
        );
        if (!actualHistory.equals(expectedHistory)) {
            throw new AssertionError("expectedHistory = " + expectedHistory + " but actualHistory = " + actualHistory);
        }

        System.out.print("OK");
    }
}
