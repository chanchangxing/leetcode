import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenchangxing on 2019/1/26.
 */
public class Generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                    continue;
                }

                list.add(lists.get(i - 1).get(j - 1) + lists.get(i - 1).get(j));
            }
            lists.add(list);
        }

        return lists;
    }

    public static void main(String[] args) {

    }
}
