/**
 * Created by chenchangxing on 2019/2/19.
 */
public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }

        String result = "";
        for (int left = 0; left < s.length(); left++) {
            char a = s.charAt(left);
            int index = s.lastIndexOf(a);
            String subString = s.substring(left, index + 1);

            String tmp;
            if (subString.length() > 1) {
                tmp = b(subString.length() - 1, subString, a);
            } else {
                tmp = subString;
            }

            result = isEquel(tmp) ? (result.length() > tmp.length() ? result : tmp): result;
        }

        return result;
    }

    public static String b (int fromIndex, String string, char firstWord) {
        if (string.lastIndexOf(firstWord, fromIndex - 1) == 0) {
            return isEquel(string) ? string: "";
        }

        int right = string.lastIndexOf(firstWord, fromIndex - 1);
        String tmp = string.substring(0, right + 1);
        String index = b(right, tmp, firstWord);
        return isEquel(string) ? string : index;
    }

    public static boolean isEquel(String string) {
        for (int left = 0, right = string.length() - 1; left <= right; left++, right--) {
            if (string.charAt(left) != string.charAt(right)) {
                return false;
            }
        }

        return true;
    }

    public static String longestPalindrome1(String s) {
        int n = s.length();

        int [] range = new int[2];
        for(int i = 0;i<n;i++){
            i = helper(s, range, i);
        }

        return s.substring(range[0],range[1]);
    }

    public static int helper(String s,int [] range, int i){
        int lo = i; int hi=i;
        while (hi<s.length()-1 && s.charAt(hi) == s.charAt(hi+1)){
            hi++;
        }

        int ret = hi;
        while (lo>0 && hi<s.length()-1 && s.charAt(lo-1)== s.charAt(hi+1)){
            lo--;
            hi++;
        }

        if(hi-lo +1 > range[1]-range[0]){
            range[0] = lo;
            range[1] = hi+1;
        }

        return ret;
    }

    public static void main (String[] args) {
        System.out.println(longestPalindrome1("babad"));
    }
}