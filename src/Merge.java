import java.util.Arrays;

/**
 * Created by chenchangxing on 2019/1/4.
 */
public class Merge {
    static void merge(int[] nums1, int m, int[] nums2, int n) {
        int [] tmp = new int[nums1.length];

        int a = 0;
        int b = 0;
        for (int i = 0; i < m + n; i++) {
            if (m - a == 0) {
                tmp[i] = nums2[b++];
                continue;
            }
            if (n - b == 0) {
                tmp[i] = nums1[a++];
                continue;
            }

            if (nums1[a] < nums2[b]) {
                tmp[i] = nums1[a++];
            } else {
                tmp[i] = nums2[b++];
            }
        }

        System.arraycopy(tmp, 0, nums1, 0, nums1.length);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {2, 0};
        int[] nums2 = new int[] {};

        merge(nums1, 1, nums2, 0);

        System.out.println(Arrays.toString(nums1));
    }
}
