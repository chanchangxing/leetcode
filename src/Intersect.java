import java.util.*;

/**
 * Created by chenchangxing on 2018/8/8.
 * <p>
 * 给定两个数组，写一个方法来计算它们的交集。
 * <p>
 * 例如:
 * 给定 nums1 = [1, 2, 2, 1], nums2 = [2, 2], 返回 [2, 2].
 * <p>
 * 注意：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 跟进:
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果nums2的元素存储在磁盘上，内存是有限的，你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0)   {
            return new int[0];
        }

        int[] ret1 = new int[Math.max(nums1.length, nums2.length)];
        int len1 = 0;
        boolean[] bl1 = new boolean[ret1.length];
        for (int i=0; i < nums2.length; i++) {
            int start = 0;
            while( (start = find(nums1, nums2[i], start)) != -1 ) {
                if(bl1[start] == false) {
                    ret1[len1++] = nums2[i];
                    bl1[start] = true;
                    break;
                }
                start++;
            }
        }

        int[] ret = new int[len1];
        for (int i=0; i<len1; i++) {
            ret[i] = ret1[i];
        }

        return ret;

    }

    public int find(int[] nums, int val, int i) {
        for (; i < nums.length; i++) {
            if(nums[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {2,2};
        int[] nums2 = {1,2,2,1};

        Intersect intersect = new Intersect();

        System.out.print(Arrays.toString(intersect.intersect(nums1, nums2)));
    }
}
