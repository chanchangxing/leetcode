import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by chenchangxing on 2018/12/1.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        final int len = nums.length;
        int n = len - 1;
        n |= 8191;
        final int hash = n;
        final int bucketSize = n + 1;
        final int[] root = new int[bucketSize];
        final int[] linked = new int[len];

        for (int i = 1; i < len; i++) {
            int self = nums[i];
            int aim = target - self;
            if (aim == nums[0]) {
                return new int[]{0, i};
            }
            int aimRootIndex = root[aim & hash];
            while (aimRootIndex != 0) {
                if (nums[aimRootIndex] == aim) {
                    return new int[]{aimRootIndex, i};
                }
                aimRootIndex = linked[aimRootIndex];
            }
            int thisIndex = self & hash;
            linked[i] = root[thisIndex];
            root[thisIndex] = i;
        }
        return null;

    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] a = new int[]{3, 2, 11, 15, 7};
        System.out.print(Arrays.toString(twoSum.twoSum(a, 9)));

        print(Byte.valueOf("1000", 2));
        print(Integer.toBinaryString(6));
    }

    static  <T>void print(T t) {
       System.out.println(t.toString());
    }
}
