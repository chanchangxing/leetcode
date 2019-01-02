import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by chenchangxing on 2018/8/7.
 */
public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 1};
        System.out.println(containsDuplicate(a));
    }
}
