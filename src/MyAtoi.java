/**
 * Created by chenchangxing on 2018/12/12.
 */
public class MyAtoi {
    public static int myAtoi(String str) {
        int a = 0;
        int b = -1;
        boolean c = false;

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //遇到非（整数、正负符号、空格）
//chars[i] != 32 && chars[i] != 189 && chars[i] < 48 && chars[i] > 57 && chars[i] == 32 && a != 0 && chars[i] == 189
            if ((chars[i] < 48 && chars[i] != 32 && chars[i] != 45 && chars[i] != 43)
                    || (chars[i] > 57 )
                    || (chars[i] == 32 && c)
                    || (chars[i] == 45 && c)
                    || (chars[i] == 43 && c)) {
                return a;
            }

            if (chars[i] == 32) {
                if (chars.length == 1) {
                    return a;
                }
                continue;
            }

            if (chars[i] == 45) {
                c = true;

                if (chars.length == 1) {
                    return a;
                }
                b = 1;
                continue;
            }

            if (chars[i] == 43) {
                c = true;

                if (chars.length == 1) {
                    return a;
                }
                b = 2;
                continue;
            }

            if (b == 1) {
                c = true;
                if (a < Integer.MIN_VALUE / 10 || (a == Integer.MIN_VALUE / 10 && chars[i] >= 56)) {
                    return Integer.MIN_VALUE;
                }
                a = a * 10 - (chars[i] - 48);
            } else {
                c = true;
                if (a > Integer.MAX_VALUE / 10 || (a == Integer.MAX_VALUE / 10 && chars[i] >= 55)) {
                    return Integer.MAX_VALUE;
                }
                a = a * 10 + (chars[i] - 48);
            }
        }

        return a;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(myAtoi("2147483648"));
    }
}
