import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenchangxing on 2019/3/12.
 */
public class GenerateParenthesis {
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        chuli("", list, n, n);
        return list;
    }
    public static void chuli(String s, List<String> list,int left, int right) {
        if (left>right) {
            return;
        }

        if (left>0) {
            chuli(s+"(", list, left-1, right);
        }
        if (right>0) {
            chuli(s+")", list, left, right-1);
        }
        if (left==0&&right==0) {
            list.add(s);
            return;
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
