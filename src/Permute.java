import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by chenchangxing on 2019/3/13.
 */
public class Permute {
    static List<List<Integer>> lists = new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }

        a(numsList, new LinkedList<>());
        return lists;
    }

    public static void a(List<Integer> nums, List<Integer> list) {
        if (nums.isEmpty()) {
            lists.add(list);
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            List<Integer> listTemp = new LinkedList<>(list);
            listTemp.add(nums.get(i));
            List<Integer> numsTemp = new ArrayList<>(nums);
            numsTemp.remove(i);
            a(numsTemp, listTemp);
        }
    }

    public static List<List<Integer>> permute1(int[] nums) {

        if(nums ==null)return result;
        int len = nums.length;
        sortNums(nums, 0, len);
        return result;
    }
    static List<List<Integer>> result = new ArrayList<List<Integer>>();
    public static void sortNums(int[] nums, int n, int len){
        List<Integer> list = new ArrayList();
        if(len-1 ==n){
            for(int i =0; i <len; i++){
                list.add(nums[i]);

            }
            result.add(list);
            return;
        }
        for(int j =n; j <len; j++){
            swap(nums,n,j);
            sortNums(nums,n+1,len);
            swap(nums,n,j);      //不还原，for不同次的循环使用的nums不同
        }
    }
    public static void swap(int[] nums, int n, int j){
        int temp = 0;
        temp = nums[n];
        nums[n] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3};
        for (List<Integer> list : permute1(a)) {
            System.out.println(list.toString());
        }
    }
}
