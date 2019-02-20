/**
 * Created by chenchangxing on 2019/2/20.
 */
public class IncreasingTriplet {
    public static boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        int m1 = nums[0];
        int m2 = nums[0];
        boolean m2Changed = false;

        for (int num: nums) {
            if (num < m1 && num < m2) {
                m1 = num;
                continue;
            }

            if (m2Changed && num > m1 && num < m2) {
                m2 = num;
                m2Changed = true;
                continue;
            }

            if (!m2Changed && num > m1) {
                m2 = num;
                m2Changed = true;
                continue;
            }

            if (m2Changed && num > m2) {
                return true;
            }
        }

        return m2Changed && m2 < nums[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,-2,6};
        System.out.println(increasingTriplet(nums));
    }
}
