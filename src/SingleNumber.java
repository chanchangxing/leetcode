import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by chenchangxing on 2018/8/7.
 * <p>
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class SingleNumber {
    static int singleNumber(int[] nums) {
        int ans = 0;
        for (int i : nums) {
            ans ^= i;
            System.out.println(ans);
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] a = new int[]{4,1,2,1,2};
//        System.out.println(singleNumber(a));

        double i = 14000604;

        int k = 0;
        while (i > 1) {
            i /= 2;
            k++;
        }

        System.out.println(k);
        System.out.println(i);
    }
}
