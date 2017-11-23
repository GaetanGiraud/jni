package com.ggiraud.benchmark;

/**
 * <p>
 * <p/>Published under the MIT License. Use at your own risk! <p/>
 *
 * @author ggiraud
 */
public class MatrixCalculationJava implements MatrixCalculation{
    public int[][] ikjAlgorithm(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                for (int j = 0; j < n; j++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }


    @Override
    public int[][] multiply(int[][] A, int[][] B) {
        return ikjAlgorithm(A, B);
    }
}
