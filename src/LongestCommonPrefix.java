/**
 * Created by chenchangxing on 2018/12/17.
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        String shortString = strs[0];
        String result = "";
        String tmp;
        int begin = 0;
        int end = 1;
        for (; end <= shortString.length();) {
            tmp = shortString.substring(begin, end);
            for (int j = 0; j < strs.length; j++) {
                if (tmp.length() > strs[j].length() || strs[j].indexOf(tmp) != 0) {
                    return result;
                } else {
                    if (j == strs.length - 1) {
                        end++;
                        if (tmp.length() > result.length()) {
                            result = tmp;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] a = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(a));
    }
}
