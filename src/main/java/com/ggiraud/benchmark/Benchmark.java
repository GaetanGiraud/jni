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

        // perform benchmark for Java
        for(int i = 1; i < 20; i++ ) results.add(performBenchmarkStep(i*10, new MatrixCalculationJava()));

        writeResultsToFile(results, "benchmark-java-results.csv");

        // perform benchmark for Native
        for(int i = 1; i < 20; i++ ) results.add(performBenchmarkStep(i*10, new MatrixCalculationNative()));

        writeResultsToFile(results, "benchmark-native-results.csv");
    }

    private static void writeResultsToFile(List<BenchmarkResult> results, String fileName) {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(fileName), "utf-8"))) {

            for(BenchmarkResult result: results) writer.write(result.toString());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static BenchmarkResult performBenchmarkStep(int n, MatrixCalculation calculation){
        MatrixGenerator generator = new MatrixGenerator(12345678l);

        int[][] matrix1 = generator.generateRandomMatrix(n);

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
