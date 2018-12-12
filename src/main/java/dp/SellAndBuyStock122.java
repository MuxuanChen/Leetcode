package dp;

/**
 * 买卖股票2
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2018-12-02
 */
public class SellAndBuyStock122 {
    public static int maxProfit(int[] prices) {
        //买入价格
        int buyPrice = Integer.MAX_VALUE;
        //一次买入卖出的利润
        int sectionPrice = 0;
        //总利润
        int sumProfit = 0;
        for (int price : prices) {
            //如果当前价格小于上次买入价格，则在今天买入股票
            if (price < buyPrice) {
                buyPrice = price;
            } else {
                //取最近一次买卖的最大利润
                sectionPrice = Math.max(sectionPrice, price - buyPrice);
                //今天卖利润更大
                if (sectionPrice < price - buyPrice) {
                    sectionPrice = price - buyPrice;
                } else {
                    //昨天卖利润更大，今天买入
                    sumProfit += sectionPrice;
                    sectionPrice = 0;
                    buyPrice = price;
                }
            }
        }

        if (sectionPrice != 0) {
            sumProfit += sectionPrice;
        }

        return sumProfit;
    }


    public static int maxProfit2(int[] prices) {
        int maxProfile = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i-1] > 0){
                maxProfile += prices[i] - prices[i-1];
            }
        }
        return maxProfile;
    }


    public static void main(String[] args) {
//        int profile = maxProfit(new int[]{6,1,3,2,4,7});
//        int profile = maxProfit(new int[]{1,2,3,4,5});
//        int profile = maxProfit(new int[]{7,6,4,3,1});
        int profile = maxProfit(new int[]{2, 1, 2, 0, 1});

        System.out.println(profile);
    }
}
