/**
 * Created by chenchangxing on 2019/1/18.
 */
public class IsPowerOfThree {
    public static boolean isPowerOfThree(int n) {
        double a = Math.log(n);
        System.out.println(a);
        double b = Math.log(3);
        System.out.println(b);
        double res = a / b;
        System.out.println(res);
        return (res - (int) (res)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(81));
    }
}
