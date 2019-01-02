import java.util.Arrays;

/**
 * Created by chenchangxing on 2018/11/30.
 */
public class MoveZeroes {
    int[] moveZeroes(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        for (; start <= end; start++) {
            if (nums[start] == 0) {
                int nextIndex = start + 1;
                for (int o = start; o <= end - 1;) {
                    if (nextIndex >= nums.length) {
                        break;
                    }
                    int pre = nums[o];
                    int next = nums[nextIndex];
                    if (next == 0) {
                        nextIndex++;
                    } else {
                        nums[o] = next;
                        nums[nextIndex] = pre;
                        o = nextIndex;
                        nextIndex++;
                    }
                }
                end--;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] a = new int[]{4,2,4,0,0,3,0,5,1,0};
        System.out.print(Arrays.toString(moveZeroes.moveZeroes(a)));
    }
}
