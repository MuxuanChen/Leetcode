package array;

/**
 * 长度最小的子数组
 * 滑动窗口，right遍历数组，left当sum大于target的时候滑动
 *
 * @author Haixiang
 * @since 2022-02-14
 */
public class MinSubArrayLen209 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int result = Integer.MAX_VALUE;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            int num = nums[right];
            sum += num;
            while (sum >= target) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
