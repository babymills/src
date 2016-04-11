package Procedure.loop.matrix_mul;

public class Test_3x3_x_3x3 {
    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int[][] b = {
                {10, 20, 30},
                {40, 50, 60},
                {70, 80, 90}};
        int[][] c = MatrixUtils.mul(a, b);

        checkHeight(c, 3);
        checkWidth(c, 3);
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
        if (c[0][2] != a[0][0] * b[0][2] + a[0][1] * b[1][2] + a[0][2] * b[2][2]) {
            throw new AssertionError();
        }

        if (c[1][0] != a[1][0] * b[0][0] + a[1][1] * b[1][0] + a[1][2] * b[2][0]) {
            throw new AssertionError();
        }
        if (c[1][1] != a[1][0] * b[0][1] + a[1][1] * b[1][1] + a[1][2] * b[2][1]) {
            throw new AssertionError();
        }
        if (c[1][2] != a[1][0] * b[0][2] + a[1][1] * b[1][2] + a[1][2] * b[2][2]) {
            throw new AssertionError();
        }

        if (c[2][0] != a[2][0] * b[0][0] + a[2][1] * b[1][0] + a[2][2] * b[2][0]) {
            throw new AssertionError();
        }
        if (c[2][1] != a[2][0] * b[0][1] + a[2][1] * b[1][1] + a[2][2] * b[2][1]) {
            throw new AssertionError();
        }

        if (c[2][2] != a[2][0] * b[0][2] + a[2][1] * b[1][2] + a[2][2] * b[2][2]) {
            throw new AssertionError();
        }
    }
}
