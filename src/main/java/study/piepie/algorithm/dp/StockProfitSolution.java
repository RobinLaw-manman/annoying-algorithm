package study.piepie.algorithm.dp;

/**
 * @author Robin
 * @date 2021-07-23 15:10
 **/
public class StockProfitSolution {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int profit0 = 0;
        int profit1 = -prices[0];
        for (int i = 1; i< prices.length; i++) {
            int tmp = profit0;
            profit0 = Math.max(profit0, profit1 + prices[i]);
            profit1 = Math.max(profit1, tmp - prices[i]);
        }
        return profit0;
    }
}