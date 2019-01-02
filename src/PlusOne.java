import java.util.Arrays;

/**
 * Created by chenchangxing on 2018/11/29.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length + 1];
        boolean up = true;

        for (int i = digits.length - 1; i >= 0; i--) {
            if (up) {
                int nums = digits[i] + 1;
                if (nums == 10) {
                    result[i + 1] = 0;
                } else {
                    result[i + 1] = nums;
                    up = false;
                }
            } else {
                result[i + 1] = digits[i];
            }
        }

        if (up) {
            result[0] = 1;
            return result;
        } else {
            int[] a = new int[digits.length];
            for (int i = 0; i < a.length; i++) {
                a[i] = result[i + 1];
            }
            return a;
        }

    }

    public static void main(String[] args) {
        PlusOne one = new PlusOne();

        int[] i = new int[]{9,9,9};
        System.out.print(Arrays.toString(one.plusOne(i)));
    }
}
