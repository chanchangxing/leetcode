/**
 * Created by chenchangxing on 2018/8/1.
 */
public class MaxProfit {
    public static int maxProfit(int[] prices) {
        int buy = 0;
        int count = 0;
        int sale = 1;

        while (buy < prices.length - 1) {
            for (; sale < prices.length; sale++) {
                if (prices[buy] >= prices[sale]) {
                    buy++;
                    sale++;
                    break;
                }

                if (sale == prices.length - 1) {
                    count += (prices[sale] - prices[buy]);
                    return count;
                }

                if (sale == prices.length - 1 || prices[sale] > prices[sale + 1]) {
                    count += (prices[sale] - prices[buy]);
                    buy = sale + 1;
                    sale = buy + 1;
                    break;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        System.out.println(maxProfit(a));
    }
}
