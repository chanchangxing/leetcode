import java.util.Arrays;

/**
 * Created by chenchangxing on 2019/1/10.
 */
public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        int[] count = new int[nums.length];
        int count1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count1 + nums[i] < 0) {
                count[i] = nums[i];
                count1 = 0;
            } else {
                count1 += nums[i];
                count[i] = count1;
            }
        }

        int max = count[0];
        for (int i = 1; i < count.length; i++) {
            max = Math.max(max, count[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
