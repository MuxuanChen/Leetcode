package dp.stock;

/**
 * @author haixiang
 * @since 2022-06-20
 */
public class MaxProfit121 {
    public int maxProfit(int[] prices) {
        //dp[][0]表示不持有股票，dp[][1]表示持有股票
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            //当前不持有股票可以从两种状态转移过来
            //1.昨天不持有股票
            //2.昨天持有股票，今天卖掉
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);

            //当前持有股票可以从两种状态转移过来
            //1.昨天持有股票
            //2.昨天不持有股票，今天买入
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[prices.length - 1][0];
    }
    
}
