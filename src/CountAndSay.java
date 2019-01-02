import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by chenchangxing on 2018/12/14.
 */
public class CountAndSay {
    public static String countAndSay(int n) {
        String a = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder b = new StringBuilder();
            int nums = 0;
            char q = ' ';
            for (int j = 0; j < a.length(); j++) {
                if (q == a.charAt(j)) {
                    nums++;
                } else {
                    if (q == ' ') {
                        q = a.charAt(j);
                        nums = 1;
                    } else {
                        b.append(String.valueOf(nums));
                        b.append(String.valueOf(q));

                        q = a.charAt(j);
                        nums = 1;
                    }
                }
            }

            b.append(nums).append(String.valueOf(a.charAt(a.length() - 1)));
            a = b.toString();
        }
        return a;
    }

    public static String countAndSay1(int n) {
        if (n == 1) return "1";
        String say = "1";
        for (int i = 1; i < n; i++) {
            String temp = count(say);
            say = temp;
        }
        return say;
    }

    private static String count(String s) {
        StringBuilder countStr = new StringBuilder();
        char sub = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (sub != s.charAt(i)) {
                countStr.append(count).append(sub);
                sub = s.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }
        countStr.append(count).append(sub);
        return countStr.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay1(5));
    }
}
