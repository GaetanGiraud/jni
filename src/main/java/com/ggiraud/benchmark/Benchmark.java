package com.ggiraud.benchmark;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * <p/>Published under the MIT License. Use at your own risk! <p/>
 *
 * @author ggiraud
 */
public class Benchmark {

    public static void main(String[] args){
        System.loadLibrary("JNI-DLL");

        List<BenchmarkResult> results = new ArrayList<>();

       // perform the benchmark on a exponentially increasing scale



        /*for(int i = 1; i < 13; i++ )

        results.add(performBenchmarkStep((int) Math.pow(2, i)));

        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("benchmark-results.csv"), "utf-8"))) {

            for(BenchmarkResult  result: results)
                writer.write(result.toString());


        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }

    public static BenchmarkResult performBenchmarkStep(int n, MatrixCalculation calculation){
        int[][] matrix1 = MatrixGenerator.generateRandomMatrix(n);

        System.out.print("Performing calculations for n = " + n);
        long startTime = System.nanoTime();

        calculation.multiply(matrix1, matrix1);

        long endTime = System.nanoTime();

        long duration = (endTime-startTime)/1000;
        System.out.println(" - Calculations took " + duration + " ms." );

        return new BenchmarkResult(duration, n );
    }


    static class BenchmarkResult {
        long duration;
        int n;

        BenchmarkResult(long duration, int n) {
            this.duration = duration;
            this.n = n;
        }

        @Override
        public String toString() {
            return duration + "," + n + "\n";
        }
    }
}
