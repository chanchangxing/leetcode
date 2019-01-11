import sun.nio.cs.ext.MacHebrew;

/**
 * Created by chenchangxing on 2019/1/11.
 */
public class Rob {
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int[] a = new int[nums.length];
        a[0] = nums[0];
        a[1] = nums[1];
        int pre = a[0];

        for (int i = 2; i < nums.length; i++) {
            a[i] = pre + nums[i];
            pre = Math.max(pre, a[i - 1]);
        }

        int max = 0;
        for (int i = 0; i < a.length; i++) {
            max = Math.max(a[i], max);
        }

        return max;
    }

    public static int rob1(int[] nums) {
        int rob = 0, notRob = 0, n = nums.length;
        for(int i = 0; i < n; ++i){
            int preRob = rob, preNotRob = notRob;
            System.out.print("preRob = " + preRob + " preNotRob = " + preNotRob);
            rob = preNotRob + nums[i];
            System.out.print(" rob = " + rob);
            notRob = Math.max(preRob, preNotRob);
            System.out.print(" notRob = " + notRob);
            System.out.println();
        }
        return Math.max(rob, notRob);
    }

    public static void main(String[] args) {
        System.out.println(rob1(new int[]{2,7,9,3,1}));
    }
}
