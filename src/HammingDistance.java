/**
 * Created by chenchangxing on 2019/1/24.
 */
public class HammingDistance {
    public static int hammingDistance(int x, int y) {
        String xx = new StringBuilder(Integer.toBinaryString(x)).reverse().toString();
        String yy = new StringBuilder(Integer.toBinaryString(y)).reverse().toString();

        System.out.println(xx + "  " + yy);

        String big = xx.length() > yy.length() ? xx : yy;
        String small = xx.length() > yy.length() ? yy : xx;

        int count = 0;

        for (int i = big.length() - 1; i >= 0; i--) {
            if (i > small.length() - 1) {
                char c =  big.charAt(i);
                if (c != '0') {
                    count++;
                }
                continue;
            }

            if (big.charAt(i) != small.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public static int hammingDistance1(int x, int y) {
        int k = x ^ y;
        int res = 0;
        while (k != 0) {
            if ((k % 2) == 1) res++;
            k = k >> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance1(1, 4));
    }
}
