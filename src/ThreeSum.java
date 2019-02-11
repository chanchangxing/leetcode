import java.util.*;

/**
 * Created by chenchangxing on 2019/1/30.
 */
public class ThreeSum {
    static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return lists;
        }

        boolean isAllZero = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                isAllZero = false;
                break;
            }
        }

        if (isAllZero) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            list.add(0);
            list.add(0);
            lists.add(list);
            return lists;
        }


        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }

        int jIndex = 0;
        int kIndex = 0;
        int iIndex = 0;
        for (int i = 0; i < nums.length - 1;) {
            int first = nums[i];
            if (first > 0) {
                break;
            }
            if (i > 0 && nums[i] == iIndex) {
                iIndex = nums[i];
                i++;
                continue;
            }
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                if (j > i + 1 && nums[j] == jIndex) {
                    j++;
                    continue;
                }

                if (k < nums.length - 1 && nums[k] == kIndex) {
                    k--;
                    continue;
                }

                if (first + nums[j] + nums[k] > 0) {
                    jIndex = nums[j];
                    kIndex = nums[k];
                    k--;
                } else if (first + nums[j] + nums[k] < 0) {
                    jIndex = nums[j];
                    kIndex = nums[k];
                    j++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(first);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    lists.add(list);
                    jIndex = nums[j];
                    kIndex = nums[k];
                    j++; k--;
                }
            }
            iIndex = nums[i];
            i++;
        }
        return lists;
    }

    static List<List<Integer>> threeSum1(int[] nums) {
        if (nums.length < 3)
            return Collections.emptyList();
        List<List<Integer>> res = new ArrayList<>();
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int negSize = 0;
        int posSize = 0;
        int zeroSize = 0;
        for (int v : nums) {
            if (v < minValue)
                minValue = v;
            if (v > maxValue)
                maxValue = v;
            if (v > 0)
                posSize++;
            else if (v < 0)
                negSize++;
            else
                zeroSize++;
        }
        if (zeroSize >= 3)
            res.add(Arrays.asList(0, 0, 0));
        if (negSize == 0 || posSize == 0)
            return res;
        if (minValue * 2 + maxValue > 0)
            maxValue = -minValue * 2;
        else if (maxValue * 2 + minValue < 0)
            minValue = -maxValue * 2;

        int[] map = new int[maxValue - minValue + 1];
        int[] negs = new int[negSize];
        int[] poses = new int[posSize];
        negSize = 0;
        posSize = 0;
        for (int v : nums) {
            if (v >= minValue && v <= maxValue) {
                if (map[v - minValue]++ == 0) {
                    if (v > 0)
                        poses[posSize++] = v;
                    else if (v < 0)
                        negs[negSize++] = v;
                }
            }
        }
        Arrays.sort(poses, 0, posSize);
        Arrays.sort(negs, 0, negSize);
        int basej = 0;
        for (int i = negSize - 1; i >= 0; i--) {
            int nv = negs[i];
            int minp = (-nv) >>> 1;
            while (basej < posSize && poses[basej] < minp)
                basej++;
            for (int j = basej; j < posSize; j++) {
                int pv = poses[j];
                int cv = 0 - nv - pv;
                if (cv >= nv && cv <= pv) {
                    if (cv == nv) {
                        if (map[nv - minValue] > 1)
                            res.add(Arrays.asList(nv, nv, pv));
                    } else if (cv == pv) {
                        if (map[pv - minValue] > 1)
                            res.add(Arrays.asList(nv, pv, pv));
                    } else {
                        if (map[cv - minValue] > 0)
                            res.add(Arrays.asList(nv, cv, pv));
                    }
                } else if (cv < nv)
                    break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        for (List<Integer> list : threeSum1(new int[]{-1, 0, 1, 2, -1, -4})) {
            System.out.println(list);
        }
    }
}
