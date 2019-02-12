import java.util.*;

/**
 * Created by chenchangxing on 2019/2/12.
 */
public class SetZeroes {
    public static void setZeroes(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    list.add(i);
                    list.add(j);
                }
            }
        }

        for (int i = 0; i < list.size(); i += 2) {
            for (int k = 0; k < matrix[list.get(i)].length; k++) {
                matrix[list.get(i)][k] = 0;
            }

            for (int j = 0; j < matrix.length; j++) {
                matrix[j][list.get(i + 1)] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{
                new int[]{1, 1, 1},
                new int[]{1, 0, 1},
                new int[]{1, 1, 1},
        };
        setZeroes(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
    }
}
