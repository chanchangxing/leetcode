import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by chenchangxing on 2018/12/4.
 */
public class Rotate {
    static void rotate(int[][] matrix) {
        for (int i = 0; i <= matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
            print(matrix);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - j - 1];
                matrix[i][matrix.length - j - 1] = temp;
            }
        }
    }

    static void print(int[][] t) {
        System.out.println("-----------------------");
        for (int i = 0; i < t.length; i++) {
            System.out.println(Arrays.toString(t[i]));
        }
    }

    static void print(int[] t) {
        System.out.println(Arrays.toString(t));
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                new int[]{5, 1, 9, 11},
                new int[]{2, 4, 8, 10},
                new int[]{13, 3, 6, 7},
                new int[]{15, 14, 12, 16},
        };
        print(matrix);
        rotate(matrix);
        print(matrix);

    }
}
