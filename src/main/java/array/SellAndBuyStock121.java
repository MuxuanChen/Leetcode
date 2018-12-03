package array;

/**
 * 买卖股票2
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2018-12-02
 */
public class SellAndBuyStock121 {
    public static int maxProfit1(int[] prices) {
        int maxProfit = 0;
        int minprice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++){
            if (prices[i] < minprice){
                minprice = prices[i];
            }else if(prices[i] - minprice > maxProfit){
                maxProfit = prices[i] - minprice;
            }
        }
        return maxProfit;
    }



    public static int maxProfit2(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfile = 0;
        for (int price : prices){
            minPrice = Math.min(price, minPrice);
            maxProfile = Math.max(maxProfile, price - minPrice);
        }
        return maxProfile;
    }
}
