import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenchangxing on 2019/1/16.
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
                continue;
            }

            if (i % 3 == 0) {
                list.add("Fizz");
                continue;
            }

            if (i % 5 == 0) {
                list.add("Buzz");
                continue;
            }

            list.add(String.valueOf(i));
        }

        return list;
    }
}
