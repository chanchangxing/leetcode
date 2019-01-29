/**
 * Created by chenchangxing on 2019/1/29.
 */
public class MissingNumber {
    public static int missingNumber(int[] nums) {
        int[] a = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            a[nums[i]] = 1;
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                return i;
            }
        }

        return 0;
    }

    public static int missingNumber1(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for(int i=0;i<=len;i++){
            if(i == len){
                sum += i;
            }else{
                sum+= i - nums[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        System.out.println(missingNumber1(new int[]{1,5, 0 ,3 , 4}));
    }
}
