package study.piepie.algorithm.dp;

/**
 * @author Robin
 * @date 2021-07-23 15:10
 **/
public class StockProfitSolution {
    public static int maxProfit(int[] prices, int k) {
        if (prices == null || prices.length == 0 || k <= 0) {
            return 0;
        }
        int lenght = prices.length;
        if (k > lenght / 2) {
            return maxProfit(prices);
        }
        int[][][] dp = new int[lenght][k + 1][2];
        for (int i = 0; i <= k; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }
        // 注意此处，第一纬度i的前一天，i-1所有值都已经在上面的for循环初始化了。
        // 所以当i的时候取前一天i-1,无论k是什么值，都能取到，已经初始化过了，第一维度总是要先初始化完
        // 此处只与i-1有关，第一维度都是i-1所以，可以去掉第一维度节省存储空间
        for (int i = 1; i < lenght; i++) {
            for (int j = k; j > 0; j--) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                // 持有股票，前一天持有，今天休息，就是前一天的收益
                // 持有股票，前一天没股票，今天买入，就是前一天的收益 - 今天的股票价格。 做了一次交易k要减一
                // k虽然是从大到小遍历，但值都只与i-1天都相关，所以能取到任何一个k的值
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[lenght - 1][k][0];
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int profit0 = 0;
        int profit1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int tmp = profit0;
            profit0 = Math.max(profit0, profit1 + prices[i]);
            profit1 = Math.max(profit1, tmp - prices[i]);
        }
        return profit0;
    }
}