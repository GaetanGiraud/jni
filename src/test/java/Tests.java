import com.ggiraud.benchmark.MatrixCalculation;
import com.ggiraud.benchmark.MatrixCalculationJava;
import com.ggiraud.benchmark.MatrixCalculationNative;
import com.ggiraud.benchmark.MatrixGenerator;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * <p>
 * <p/>Published under the MIT License. Use at your own risk! <p/>
 *
 * @author ggiraud
 */
public class Tests {
    @BeforeClass
    public static void beforeClass() {
        System.loadLibrary("JNI-DLL");
    }

    @Test
    public void testSerialization(){
        int[][] matrix = { {1 , 2 } , { 3, 4} };
        int[] expectedArray = {1 , 2, 3, 4};
        int[] matrixArray = MatrixGenerator.serializeMatrix(matrix);

        assertArrayEquals(expectedArray ,matrixArray);


    }

    @Test
    public void testDeserialization(){

        int[] array = {1 , 2, 3, 4};
        int[][] expectedMatrix = { {1 , 2 } , { 3, 4} };
        int[][] matrix = MatrixGenerator.deSerializeMatrix(array, 2);

        assertArrayEquals(expectedMatrix ,matrix);
    }

    @Test
    public void testJavaAlgorithm(){
        MatrixCalculationJava calculation = new MatrixCalculationJava();

        int[][] matrix = { {1 , 2 } , { 3, 4} };

        int[][] results = calculation.multiply(matrix, matrix);

        /*
            | 1 2 | *  | 1 2 | = | 7  10 |
            | 3 4 |    | 3 4 |   | 15 20 |
         */
        int[][] expectedResults = { { 7, 10}, {15, 22} };

        assertArrayEquals(expectedResults ,results);
    }

    @Test
    public void testNativeAlgorithm() {
        MatrixCalculationNative calculation = new MatrixCalculationNative();

        int[] serializedMatrix = {1, 2, 3, 4};

        int[] resultNatives = calculation.ikjAlgorithmNative(serializedMatrix, serializedMatrix, 2);

        /*
            | 1 2 | *  | 1 2 | = | 7  10 |
            | 3 4 |    | 3 4 |   | 15 20 |
         */
        int[] expectedResults = { 7, 10, 15, 22 };

        assertArrayEquals(expectedResults ,resultNatives);
    }

    @Test
    public void testNativeMethodWithSerialization() {
        MatrixCalculationNative calculation = new MatrixCalculationNative();

        int[][] matrix = { {1 , 2 } , { 3, 4} };

        int[][] results = calculation.multiply(matrix, matrix);

        /*
            | 1 2 | *  | 1 2 | = | 7  10 |
            | 3 4 |    | 3 4 |   | 15 20 |
         */
        int[][] expectedResults = { { 7, 10}, {15, 22} };

        assertArrayEquals(expectedResults ,results);
    }
}
