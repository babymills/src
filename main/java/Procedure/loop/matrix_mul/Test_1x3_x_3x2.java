package Procedure.loop.matrix_mul;

public class Test_1x3_x_3x2 {
    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3},
        };
        int[][] b = {
                {10, 20},
                {30, 40},
                {50, 60},
        };
        int[][] c = MatrixUtils.mul(a, b);

        checkHeight(c, 1);
        checkWidth(c, 2);
        checkValues(a, b, c);

        System.out.print("OK");
    }

    private static void checkHeight(int[][] matrix, int expectedHeight) {
        if (matrix.length != expectedHeight) {
            throw new AssertionError();
        }
    }

    private static void checkWidth(int[][] matrix, int expectedWidth) {
        for (int[] row : matrix) {
            if (row.length != expectedWidth) {
                throw new AssertionError();
            }
        }
    }

    private static void checkValues(int[][] a, int[][] b, int[][] c) {
        if (c[0][0] != a[0][0] * b[0][0] + a[0][1] * b[1][0] + a[0][2] * b[2][0]) {
            throw new AssertionError();
        }
        if (c[0][1] != a[0][0] * b[0][1] + a[0][1] * b[1][1] + a[0][2] * b[2][1]) {
            throw new AssertionError();
        }
    }
}
