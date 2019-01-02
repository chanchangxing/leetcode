import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by chenchangxing on 2018/12/11.
 */
public class IsPalindrome {
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder result=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if((s.charAt(i)>='a'&&s.charAt(i)<='z' )||(s.charAt(i)>='0'&&s.charAt(i)<='9'))
                result.append(s.charAt(i));
        }

        String s2 = result.toString();

//        String reg = "[^a-zA-Z0-9]";
//        String s2 = s.replaceAll(reg, "").toLowerCase();

        System.out.println(s2);

        char[] s2arrya = s2.toCharArray();

        for (int i = 0; i < s2.length() / 2; i++) {
            if (s2.charAt(i) != s2.charAt(s2.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome2(String s) {
        char[] arr = s.toCharArray();
        int lo = 0, hi = arr.length - 1;
        while (hi > lo) {
            //48~57 65~90 97~122
            if (!(48 <= arr[lo] && arr[lo] <= 57) && !(65 <= arr[lo] && arr[lo] <= 90) && !(97 <= arr[lo] && arr[lo] <= 122)) {
                lo++;
                continue;
            }
            if (!(48 <= arr[hi] && arr[hi] <= 57) && !(65 <= arr[hi] && arr[hi] <= 90) && !(97 <= arr[hi] && arr[hi] <= 122)) {
                hi--;
                continue;
            }

            if(48 <= arr[lo] && arr[lo] <= 57 && 48 <= arr[hi] && arr[hi] <= 57) {
                if (arr[lo] != arr[hi]) {
                    return false;
                }
            } else if (((65 <= arr[lo] && arr[lo] <= 90) || (97 <= arr[lo] && arr[lo] <= 122)) && ((65 <= arr[hi] && arr[hi] <= 90) || (97 <= arr[hi] && arr[hi] <= 122))) {
                if (arr[lo] != arr[hi] && arr[lo] - arr[hi] != 32 && arr[lo] - arr[hi] != -32) {
                    return false;
                }
            } else {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(IsPalindrome.isPalindrome2("A1 man, a plan, a canal: Panam1a"));
    }
}
