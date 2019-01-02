import java.util.Objects;

/**
 * Created by chenchangxing on 2018/12/13.
 */
public class StrStr {
    public static int strStr(String haystack, String needle) {
        if (Objects.equals(needle, "")) {
            return 0;
        }

        char[] haystacks = haystack.toCharArray();
        char[] needles = needle.toCharArray();
        for (int i = 0; i < haystacks.length - (needle.length() - 1); i++) {
            if (haystacks[i] == needles[0]) {
                if (haystack.substring(i, i + needle.length()).equals(needle)) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
            System.out.println(strStr("aaaaa", ""));
    }
}
