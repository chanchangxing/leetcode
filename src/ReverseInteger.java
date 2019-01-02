/**
 * Created by chenchangxing on 2018/12/6.
 */
public class ReverseInteger {
    public static int reverseInteger(int x) {
        double r = 0;
        while (x != 0) {
            r = r * 10 + x % 10;
            x /= 10;
        }

        return (r > Math.pow(2, 31) - 1 || r < -Math.pow(2, 31)) ? 0 : (int) r;
    }

    public static void main(String[] args) {
        System.out.println(reverseInteger(1056389759));
    }
}
