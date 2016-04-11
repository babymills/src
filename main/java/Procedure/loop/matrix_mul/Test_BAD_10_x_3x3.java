package Procedure.loop.matrix_mul;

public class Test_BAD_10_x_3x3 {
    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3},
                null,
                {7, 8, 9}};
        int[][] b = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        try {
            MatrixUtils.mul(a, b);
        } catch (IllegalArgumentException e) {
            System.out.print("OK");
        }
    }
}
