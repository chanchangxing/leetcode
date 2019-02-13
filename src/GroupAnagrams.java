import java.util.*;

/**
 * Created by chenchangxing on 2019/2/13.
 */
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] a = strs[i].toCharArray();
            Arrays.sort(a);
            String string = String.valueOf(a);
            if (map.containsKey(string)) {
                map.get(string).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(string, list);
            }
        }

        List<List<String>> lists = new ArrayList<>(map.values());


        return lists;
    }

    public static void main(String[] args) {
        String[] a = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
        for (List<String> list: groupAnagrams(a)) {
            System.out.println(list.toString());
        }
    }
}
