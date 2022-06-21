package dp.stock;

/**
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * <p>
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * <p>
 * 返回 你能获得的 最大 利润 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author haixiang
 * @since 2022-06-20
 */
public class MaxProfit122 {
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
            //2.昨天不持有股票，今天买入,和单次买入卖出的区别在于，今天买入的时候会有dp[i - 1][0]的金额，因为可以多次交易，存在前几次交易的利润
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}
