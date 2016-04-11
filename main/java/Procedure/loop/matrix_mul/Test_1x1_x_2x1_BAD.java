package Procedure.loop.matrix_mul;

public class Test_1x1_x_2x1_BAD {
    public static void main(String[] args) {
        int[][] a = {{1}};
        int[][] b = {{1}, {1}};

        try {
            MatrixUtils.mul(a, b);
        } catch (IllegalArgumentException e) {
            System.out.print("OK");
        }
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
        if (c[0][0] != a[0][0] * b[0][0]) {
            throw new AssertionError();
        }
    }
}
