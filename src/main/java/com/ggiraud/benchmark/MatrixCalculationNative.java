package com.ggiraud.benchmark;

/**
 * <p>
 * <p/>Published under the MIT License. Use at your own risk! <p/>
 *
 * @author ggiraud
 */
public class MatrixCalculationNative implements MatrixCalculation{
    public static int[] serializeMatrix(int[][] matrix){
        // assuming here squared matrix
        int n = matrix.length;

        int[] arrayMatrix = new int[n*n];

        for(int i =0; i < n; i++){
            int[] row = matrix[i];

            for(int j =0; j < row.length; j++ ){
                arrayMatrix[i*n + j] = row[j];
            }

        }

        return arrayMatrix;
    }

    public static int[][] deSerializeMatrix(int[] matrixArray, int n){

        int[][] matrix = new int[n][n];

        for(int i =0; i < n; i++){
            for(int j =0; j < n; j++ ){
                matrix[i][j] = matrixArray[i*n + j];
            }

        }

        return matrix;
    }

    @Override
    public int[][] multiply(int[][] A, int[][] B) {
        return deSerializeMatrix(ikjAlgorithmNative(serializeMatrix(A), serializeMatrix(B), A.length), A.length);
    }

    public native int[] ikjAlgorithmNative(int[] A, int[] B, int length);
}
