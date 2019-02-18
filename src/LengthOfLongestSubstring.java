import sun.nio.cs.ext.MacHebrew;

import java.util.*;

/**
 * Created by chenchangxing on 2019/2/16.
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        int result = 1;
        for (int i = 0, k = 0 ; i < s.length(); i++) {
            int tmp = 1;
            for (int j = i - 1; j >= k; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    k = j + 1;
                    break;
                }
                tmp++;
            }
            result = Math.max(result, tmp);
        }

        return result;
    }

    public static int lengthOfLongestSubstring1(String s) {
        int ans = 0;
        int[] vis = new int[257];
        int len = s.length();
        int left = -1;
        Arrays.fill(vis,-1);
        for(int i = 0; i < len; i++) {
            if(vis[s.charAt(i)] > left) {
                left = vis[s.charAt(i)];
            }
            ans = Math.max(ans,i - left);
            vis[s.charAt(i)] = i;
        }

        return ans;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring1("pwwkew"));
    }
}
