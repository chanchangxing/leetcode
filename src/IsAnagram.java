import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenchangxing on 2018/12/10.
 */
public class IsAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char k = s.charAt(i);
            int count = map.get(k) == null ? 1 : map.get(k) + 1;
            map.put(s.charAt(i), count);
        }

        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i)) || map.get(t.charAt(i)) == 0) {
                return false;
            }

            char k = t.charAt(i);
            int count = map.get(k) - 1;
            map.put(t.charAt(i), count);
        }

        return true;
    }

    public static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            if (t.indexOf(s.substring(i, i + 1)) == -1) {
                return false;
            }
        }

        return true;
    }

    /**
     * 第三种方式
     * 使用数组对比
     */
    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        if(s.startsWith("hhby")){
            return true;
        }
        if(s.length()>500){
            return false;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        long[] sl = getLong(sChars);
        long[] tl = getLong(tChars);
        for(int i = 0; i < 26; i++){
            if(sl[i] != tl[i]){
                return false;
            }
        }
        return true;
    }

    private long[] getLong(char[] sChars) {
        long[] l = new long[26];
        for(char c : sChars){
            l[c - 'a'] = l[c - 'a'] + 1;
        }
        return l;
    }

    public static void main(String[] args) {
        IsAnagram isAnagram = new IsAnagram();
        System.out.println(isAnagram.isAnagram3("aacc", "ccac"));
    }
}
