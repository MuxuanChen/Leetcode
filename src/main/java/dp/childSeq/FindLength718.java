package dp.childSeq;

/**
 * 718. 最长重复子数组
 * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 *
 * @author Haixiang
 * @since 2022-09-15
 */
public class FindLength718 {
    public int findLength(int[] nums1, int[] nums2) {
        int[] dp = new int[nums1.length + 1];
        int res = 0;
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = nums2.length; j > 0; j--) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = dp[j - 1] + 1;
                } else {
                    dp[j] = 0;
                }
                res = Math.max(res, dp[j]);
            }
        }
        return res;
    }
}
