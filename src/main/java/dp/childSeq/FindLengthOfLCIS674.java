package dp.childSeq;

import java.util.Arrays;

/**
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * <p>
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-continuous-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author haixiang
 * @since 2022-07-23
 */
public class FindLengthOfLCIS674 {
    public int findLengthOfLCIS(int[] nums) {
        int maxLength = 1;
        int length = nums.length;
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                dp[i + 1] = dp[i] + 1;
            }
            if (dp[i + 1] > maxLength) {
                maxLength = dp[i + 1];
            }
        }
        return maxLength;
    }
}
