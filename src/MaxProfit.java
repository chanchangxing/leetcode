import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by chenchangxing on 2018/8/1.
 */
public class MaxProfit {
    public static int maxProfit(int[] prices) {
        int[] b = new int[prices.length];

        int currentPrice = -1;
        for (int i = 0; i < prices.length; i++) {
            if (currentPrice == -1 || currentPrice > prices[i]) {
                currentPrice = prices[i];
                continue;
            }

            b[i] = prices[i] - currentPrice;
        }

        int max = 0;
        for (int i = 0; i < b.length; i++) {
            max = Math.max(max, b[i]);
        }

        return max;
    }

    public static int maxProfit1(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int max = 0;
        int min_price = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int cur_price = prices[i];
            if (cur_price - min_price > max) {
                max = cur_price - min_price;
            }
            min_price = min_price > cur_price ? cur_price : min_price;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        System.out.println(maxProfit1(a));
    }
}
