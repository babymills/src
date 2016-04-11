package Procedure.loop.matrix_mul;

public class Test_BAD_31_x_3x3 {
    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3, 4},
                {4, 5, 6}};
        int[][] b = {
                {1, 2},
                {3, 4},
                {5, 6}};
        try {
            MatrixUtils.mul(a, b);
        } catch (IllegalArgumentException e) {
            System.out.print("OK");
        }
    }
}
