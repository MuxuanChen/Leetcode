package dp;

import java.sql.Array;
import java.util.Arrays;

/**
 * 买卖股票2
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2018-12-02
 */
public class SellAndBuyStock123 {

    public static int maxProfit(int[] prices) {
        int firstBuy = Integer.MIN_VALUE, firstSell = 0;
        int secondBuy = Integer.MIN_VALUE, secondSell = 0;
        for (int curPrice : prices) {
            if (firstBuy < -curPrice) {
                firstBuy = -curPrice;
            }
            if (firstSell < firstBuy + curPrice) {
                firstSell = firstBuy + curPrice;
            }
            if (secondBuy < firstSell - curPrice) {
                secondBuy = firstSell - curPrice;
            }
            if (secondSell < secondBuy + curPrice) {
                secondSell = secondBuy + curPrice;
            }
        }
        return secondSell;
    }

    public static int maxProfit2(int[] prices) {
        if (prices.length <= 0) {
            return 0;
        }
        //三维分别表示：天数, 交易次数，拥有股票的状态（不动，买入一股，卖出一股）
        int[][][] mp = new int[prices.length][3][2];
        /**
         * 初始化第一天的数据
         */
        //状态：第一天、交易次数0、无股票
        mp[0][0][0] = 0;
        //状态：第一天、交易次数0、买入一股
        mp[0][0][1] = -prices[0];
        //状态：第一天、交易次数1
        mp[0][1][0] = 0;
        mp[0][1][1] = -prices[0];
        //状态：第一天、交易次数2
        mp[0][2][0] = 0;
        mp[0][2][1] = -prices[0];

        //第二天开始
        int maxProfit = 0;
        //天数
        for (int i = 1; i < prices.length; i++) {
            //交易次数
            for (int j = 0; j <= 2; j++) {
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
        int profile = maxProfit2(new int[]{1, 2, 3, 4, 5});
//        int profile = maxProfit(new int[]{7,6,4,3,1});
//        int profile = maxProfit2(new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0});

        System.out.println(profile);
    }
}
