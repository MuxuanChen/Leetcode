package dp.stock;

/**
 * 给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
 * <p>
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * <p>
 * 返回获得利润的最大值。
 * <p>
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author haixiang
 * @since 2022-06-21
 */
public class MaxProfit714 {
    public int maxProfit(int[] prices, int fee) {
        //dp[][0]表示不持有股票，dp[][1]表示持有股票
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            //当前不持有股票可以从两种状态转移过来
            //1.昨天不持有股票
            //2.昨天持有股票，今天卖掉
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);//这里的区别就在于需要减去手续费fee

            //当前持有股票可以从两种状态转移过来
            //1.昨天持有股票
            //2.昨天不持有股票，今天买入,和单次买入卖出的区别在于，今天买入的时候会有dp[i - 1][0]的金额，因为可以多次交易，存在前几次交易的利润
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}
