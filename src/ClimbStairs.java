/**
 * Created by chenchangxing on 2019/1/8.
 */
public class ClimbStairs {
    private static int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] nums = new int[n + 1];
        nums[1] = 1;
        nums[2] = 2;
        climb(nums, n);
        return nums[n];

    }

    private static void climb(int[] nums, int n) {
        int x = n - 1;
        int y = n - 2;

        if (x > 2 && nums[x] == 0) {
            climb(nums, x);
        }
        if (y > 2 && nums[y] == 0) {
            climb(nums, y);
        }

        nums[n] = nums[x] + nums[y];
    }

    private static int climbStairs1(int n) {
        int[] a = new int[1000];
        a[0] = a[1] = 1;
        for (int i = 2; i < 46; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }
}
