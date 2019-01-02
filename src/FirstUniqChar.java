import java.util.*;

/**
 * Created by chenchangxing on 2018/12/7.
 */
public class FirstUniqChar {
    public static int firstUniqChar2(String s) {
        int res = -1;
        for(char i ='a';i<='z';i++){
            int index = s.indexOf(i);
            if(index!=-1 && index == s.lastIndexOf(i)){
                res = (res==-1 || res > index) ? index : res;
            }
        }
        return res;
    }

    public static int firstUniqChar(String s) {
        if (Objects.equals(s, "")) {
            return -1;
        }

        Map<String, Integer> map = new HashMap<>();
        int[] count = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.substring(i, i + 1))) {
                map.put(s.substring(i, i + 1), i);
                count[i] = 1;
            } else {
                map.put(s.substring(i, i + 1), s.length());

            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.containsValue(i)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar2("leetcode"));
    }
}
