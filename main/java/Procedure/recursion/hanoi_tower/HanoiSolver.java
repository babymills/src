package Procedure.recursion.hanoi_tower;

public class HanoiSolver {
    public static void solve(Stack from, Stack help, Stack to, int count) {
        if (count > 0) {
//            solve(?, ?, ?, count - 1);
            int biggest = from.pop();
            to.push(biggest);
//            solve(?, ?, ?, count - 1);
        }
    }
}
