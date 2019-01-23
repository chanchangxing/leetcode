/**
 * Created by chenchangxing on 2019/1/23.
 */
public class HammingWeight {
    public static int hammingWeight(int n) {
        String b = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    public static int hammingWeight1(int n) {
        int count = 0;
        while(n != 0){
            n &= (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        hammingWeight(4);
    }
}
