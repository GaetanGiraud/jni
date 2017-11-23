package com.ggiraud.benchmark;

/**
 * <p>
 * <p/>Published under the MIT License. Use at your own risk! <p/>
 *
 * @author ggiraud
 */
public class MatrixCalculationNative implements MatrixCalculation{
    @Override
    public int[][] multiply(int[][] A, int[][] B) {
        return MatrixGenerator.deSerializeMatrix(ikjAlgorithmNative(MatrixGenerator.serializeMatrix(A), MatrixGenerator.serializeMatrix(B), A.length), A.length);
    }

    public native int[] ikjAlgorithmNative(int[] A, int[] B, int length);
}
