package dp.backpack;

/**
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 * <p>
 * 题目数据保证答案符合 32 位整数范围。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/combination-sum-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Haixiang
 * @since 2022-05-27
 */
public class CombinationSum4_377 {
    public int combinationSum4(int[] nums, int target) {
        //dp[i]定义为目标i的组合数
        int[] dp = new int[target + 1];
        dp[0] = 1;
        //背包
        for (int i = 0; i <= target; i++) {//包含target
            //物品
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] > i) {//目标是会变的，这里得用i而不是target
                    continue;
                }
                dp[i] += dp[i - nums[j]];//nums[j]表示物品价值
            }
        }
        return dp[target];
    }
}
