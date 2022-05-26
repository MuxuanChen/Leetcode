package dp.backpack;

/**
 * 416. 分割等和子集
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 *
 * @author Haixiang
 * @since 2022-05-11
 */
public class CanPartition416 {
    public boolean canPartition(int[] nums) {
        //确定一维数组大小
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        //确定遍历顺序
        /**
         * i的遍历：遍历物品
         */
        for (int i = 0; i < nums.length; i++) {
            /**
             * j的遍历：遍历背包，从大到小保证同一个物品只放入一次
             */
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }


}
