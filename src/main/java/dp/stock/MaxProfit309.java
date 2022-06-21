package dp.stock;

/**
 * @author haixiang
 * @since 2022-06-21
 */
public class MaxProfit309 {
    /**
     * 1.买入
     * 2.卖出已过冷冻期
     * 3.卖出
     * 4.卖出在冷冻期期间
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length <= 0) {
            return 0;
        }
        int[][] dp = new int[length][4];
        dp[0][0] = -prices[0];
        for (int i = 1; i < length; i++) {
            //买入状态：1.从前一天的买入状态转移过来；2.从卖出已过冷冻期转移来；3.从卖出在冷冻期间转移过来
            dp[i][0] = Math.max(dp[i - 1][3] - prices[i], Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]));
            //卖出已过冷冻期：1.从卖出已过冷冻期的状态转移过来；2.从卖出在冷冻期期间转移过来
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            //卖出：1.从买入状态转移过来
            dp[i][2] = dp[i - 1][0] + prices[i];
            //卖出在冷冻期期间：1.从卖出转移过来
            dp[i][3] = dp[i - 1][2];
        }
        return Math.max(dp[length - 1][3], Math.max(dp[length - 1][1], dp[length - 1][2]));
    }
}
