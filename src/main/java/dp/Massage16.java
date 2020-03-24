package dp;

/**
 * 按摩师
 * 动态规划，至当前次的总和 = max(至前一次的总和，至前两次总和 + 当次)
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2020-03-24
 */
public class Massage16 {
    public int massage(int[] nums) {
        int first = 0, second = 0;
        for (int i = 0; i < nums.length; i++){
            //到当前次的总和
            int current = Math.max(second, first + nums[i]);
            first = second;
            second = current;
        }
        return second;
    }
}
