package dp.backpack;

import java.util.Arrays;

/**
 * @author Haixiang
 * @since 2022-05-26
 */
public class BackPack01 {
    /**
     * 先遍历物品，再倒序遍历背包，倒序是避免同一个物品放入多次
     * [0, 15, 15, 15, 15]
     * [0, 15, 15, 20, 35]
     * [0, 15, 15, 20, 35]
     *
     * @param args
     */
    public static void main(String[] args) {
        //背包容量
        int bagWeight = 4;
        //物品重量
        int[] weight = new int[]{1, 3, 4};
        //物品价值
        int[] value = new int[]{15, 20, 30};
        //dp数组
        int[] dp = new int[5];
        for (int i = 0; i < weight.length; i++) { // 遍历物品
            for (int j = bagWeight; j >= weight[i]; j--) { // 遍历背包容量
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
            System.out.println(Arrays.toString(dp));
        }
    }

    /**
     * 错误！不能先遍历背包再遍历物品，这样会导致一个背包最多只放入了一个物品
     * <p>
     * [0, 0, 0, 0, 30]
     * [0, 0, 0, 20, 30]
     * [0, 0, 15, 20, 30]
     * [0, 15, 15, 20, 30]
     *
     * @param args
     */
    public static void main2(String[] args) {
        //背包容量
        int bagWeight = 4;
        //物品重量
        int[] weight = new int[]{1, 3, 4};
        //物品价值
        int[] value = new int[]{15, 20, 30};
        //dp数组
        int[] dp = new int[5];
        /**
         * 错误遍历方式
         */
        for (int i = bagWeight; i > 0; i--) { // 遍历背包容量
            for (int j = 0; j < weight.length; j++) { // 遍历物品
                if (i - weight[j] < 0) {
                    continue;
                }
                dp[i] = Math.max(dp[i], dp[i - weight[j]] + value[j]);
            }
            System.out.println(Arrays.toString(dp));
        }
    }
}
