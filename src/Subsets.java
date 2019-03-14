import com.sun.tools.corba.se.idl.InterfaceGen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenchangxing on 2019/3/14.
 */
public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        a(nums, 0, lists, new ArrayList<>());
        lists.add(new ArrayList<>());
        return lists;
    }

    public static void a(int[] nums, int n, List<List<Integer>> lists, List<Integer> list) {
        if (n == nums.length) return;

        for (int i = n; i < nums.length; i++) {
            List<Integer> alist = new ArrayList<>(list);
            alist.add(nums[i]);
            lists.add(alist);
            a(nums, i + 1, lists, new ArrayList<>(alist));
        }
    }

    public static void main(String[] args) {
        for (List<Integer> list : subsets(new int[]{1, 2, 3})) {
            System.out.println(list.toString());
        }
    }
}
