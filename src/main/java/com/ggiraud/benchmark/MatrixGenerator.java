package com.ggiraud.benchmark;

import java.util.Random;

/**
 * <p>
 * <p/>Published under the MIT License. Use at your own risk! <p/>
 *
 * @author ggiraud
 */
public class MatrixGenerator {
    private final long seed;

    private final Random random;

    public MatrixGenerator(long seed) {
        this.seed = seed;
        random = new Random(seed);
    }

    public int[][] generateRandomMatrix(int n){
        int[][] matrix = new int[n][n];


        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                matrix[i][j] = random.nextInt();
            }
        }
        return matrix;
    }

}
