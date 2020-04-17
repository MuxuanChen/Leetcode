package dp;

/**
 * 55. 跳跃游戏
 *
 * @author Haixiang
 * @email haixiang7c6@gmail.com
 * @since 2020-04-17
 */
public class CanJump55 {
    public boolean canJump(int[] nums) {
        if (nums.length < 2) {
            return true;
        }
        int maxIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            //maxIndex < i表示走不到当前这一步，后面的位置也就走不到了，直接结束
            if (maxIndex < i) {
                break;
            }
            //当前最远的位置等于(当前位置 + 跳跃距离）和（目前位置能到的最远位置）之间的较大值
            maxIndex = Math.max(i + nums[i], maxIndex);
        }

        //判断能走到的最远位置是否能达到最后一个位置
        return maxIndex >= nums.length - 1;
    }

    public static void main(String[] args) {
        boolean res = new CanJump55().canJump(new int[]{3, 2, 1, 0, 4});
        System.out.println(res);
    }
}
