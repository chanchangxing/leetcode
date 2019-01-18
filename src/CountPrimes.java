/**
 * Created by chenchangxing on 2019/1/17.
 */
public class CountPrimes {
    public static int countPrimes(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }

        int[] nums = new int[n];
        nums[0] = -1;
        nums[1] = -1;

        for (int i = 2; i < n; i++) {
            if (nums[i] == 0) {
                if (i * i > n) {
                    break;
                }
                for (int a = 2; a * i < n; a++) {
                    nums[a * i] = -1;
                }
            }
        }

        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                b++;
            }
        }

        return b;
    }

    public static boolean isPrimes(int i) {
        for (int a = 2; a < i; a++) {
            if (i % a == 0) {
                return false;
            }
        }

        return true;
    }

    public static int countPrimes1(int n) {
        if(n < 3)
            return 0;
        boolean[] arr = new boolean[n];
        int count = n/2;
        for(int i = 3;i*i<n;i+=2){
            if(arr[i]) continue;
            for(int j = i*i;j<n;j+=2*i){
                if(!arr[j]){
                    count--;
                    arr[j] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes1(100));
    }
}
