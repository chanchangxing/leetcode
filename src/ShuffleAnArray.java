import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by chenchangxing on 2019/1/14.
 */
public class ShuffleAnArray {
    int[] mNums;
    private Random random = new Random();

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return mNums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int[] tmp = new int[mNums.length];
        for (int i = tmp.length; i > 0; ) {
            if (mNums[i - 1] != 0) {
                int index = random.nextInt(mNums.length);
                if (tmp[index] == 0) {
                    tmp[index] = mNums[i - 1];
                    i--;
                }
            } else {
                i--;
            }
        }
        return tmp;
    }

    public ShuffleAnArray(int[] nums) {
        mNums = new int[nums.length];
        System.arraycopy(nums, 0, mNums, 0, nums.length);
    }



    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 0, 3};
        ShuffleAnArrayBest anArray = new ShuffleAnArrayBest(nums);
        System.out.println(Arrays.toString(anArray.shuffle()));

    }
}

class ShuffleAnArrayBest {
    private int[] original;
    private int[] values;
    private Random random;

    public ShuffleAnArrayBest(int[] nums) {
        original = nums;
        values = Arrays.copyOf(nums,nums.length);
        random = new Random();
    }

    public int[] reset() {
        values = Arrays.copyOf(original,original.length);
        return values;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int rightEnd = values.length -1;
        int r;
        while (rightEnd >0)
        {
            r = random.nextInt(rightEnd + 1);
            if(r != rightEnd)
                swap(values,r,rightEnd);
            rightEnd--;
        }
        return values;
    }


    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}