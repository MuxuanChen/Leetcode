package dp;

import java.util.Arrays;

/**
 * 买卖股票2
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2018-12-02
 */
public class SellAndBuyStock188 {

    public static int maxProfit(int k, int[] prices) {
        if (prices.length <= 0 || k <= 0) {
            return 0;
        }

        int maxProfit = 0;
        /**
         * 当k大于数组长度的时候就退化成"尽可能地完成更多的交易获取的最大利润"，只要卖出价格比买入价格高就算入到利润中
         */
        if (k > prices.length) {
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }

        //三维分别表示：天数, 交易次数，拥有股票的状态（不动，买入一股，卖出一股）
        int[][][] mp = new int[prices.length][k + 1][2];
        /**
         * 初始化数据
         */
        for (int i = 0; i <= k; i++) {
            //状态：第一天、交易次数i、无股票
            mp[0][i][0] = 0;
            //状态：第一天、交易次数i、有股票
            mp[0][i][1] = -prices[0];
        }


        //第二天开始
        //天数
        for (int i = 1; i < prices.length; i++) {
            //交易次数
            for (int j = 0; j <= k; j++) {
                if (j == 0) {
                    //当前没有股票,买入算一次交易，卖出不算
                    mp[i][j][0] = Math.max(mp[i - 1][j][0], 0);
                    //当前拥有股票
                    mp[i][j][1] = Math.max(mp[i - 1][j][1], 0);
                } else {
                    //当前没有股票,买入算一次交易，卖出不算，1：前一天没有股票，2：前一天有股票今天卖出
                    mp[i][j][0] = Math.max(mp[i - 1][j][0], mp[i - 1][j][1] + prices[i]);
                    //当前拥有股票，1：前一天有股票，2：前一天没有股票今天买入
                    mp[i][j][1] = Math.max(mp[i - 1][j][1], mp[i - 1][j - 1][0] - prices[i]);
                }

                int[] all = new int[]{maxProfit, mp[i][j][0], mp[i][j][1]};
                maxProfit = Arrays.stream(all).max().getAsInt();
            }
        }
        return maxProfit;
    }


    public static void main(String[] args) {
//        int profile = maxProfit2(new int[]{3, 3, 5, 0, 0, 3, 1, 4});
        int profile = maxProfit(2, new int[]{2, 4, 1});
//        int profile = maxProfit(1, new int[]{1});
//        int profile = maxProfit2(new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0});

        System.out.println(profile);
    }
}
