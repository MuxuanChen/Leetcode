package dp;

import java.util.Arrays;

/**
 * 最长上升序列
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2020-03-14
 */
public class LengthOfLIS300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        //子序列最大长度数组
        int dp[] = new int[nums.length];
        int res = 1;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    //重点1：遍历原数组的某个元素时，它的子序列最大长度就是在它之前的所有子序列中的最大长度 + 1
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                //重点2，遍历原数组时得到的子序列最大长度，取最大的子序列长度
                res = Math.max(dp[i], res);
            }
        }
        return res;
    }
}
