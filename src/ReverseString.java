import sun.rmi.runtime.Log;

/**
 * Created by chenchangxing on 2018/12/5.
 */
public class ReverseString {
    private static String reverseString(String s) {
        if (s.length() <= 1) {
            return s;
        }

        char[] a = new char[s.length()];
        char[] b = s.toCharArray();
        for (int i = 0; i < s.length() / 2; i++) {
            a[i] = b[s.length() - 1 - i];
            a[s.length() - 1 - i] = b[i];
        }

        if (s.length() % 2 != 0) {
            a[s.length() / 2] = b[s.length() / 2];
        }

        return String.valueOf(a);
    }

    public static void main(String[] args) {
//        System.out.println(reverseString("hello"));

        System.out.println(Integer.toBinaryString(12));
        System.out.println(Integer.toBinaryString(21));
    }
}
