package Procedure.loop.matrix_mul;

public class Test_3x3_x_BAD_11 {
    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3},
                {4, 5, 6}};
        int[][] b = {
                {1, 2},
                null,
                {7, 8}};
        try {
            MatrixUtils.mul(a, b);
        } catch (IllegalArgumentException e) {
            System.out.print("OK");
        }
    }
}
