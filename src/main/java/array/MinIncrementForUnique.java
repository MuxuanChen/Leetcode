package array;

/**
 * 945. 使数组唯一的最小增量
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2020-03-22
 */
public class MinIncrementForUnique {
    /**
     * 方法一：计数法
     * 1.最简单的想法是遇到重复的数字一直累加，一直加到没有出现过的数为止，这样在最坏的情况下复杂度为O(N²)，例如数组中所有元素都为1的情况。
     * 2.遇到重复的数字先保存下来，等遇到没有出现过的数的时候，就将之前重复的数字增加成这个未出现过的数字。
     * 3.不用保存重复的数字，用一个变量计数重复的次数，并且将操作次数先减去这个数，然后再遇到未出现的数的时候再加上这个数。
     */
    public int minIncrementForUnique(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int[] count = new int[8000];

        int ans = 0;
        int taken = 0;
        for (int i : A) {
            count[i]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 1) {
                taken += count[i] - 1;
                ans -= i * (count[i] - 1);
            } else if (taken > 0 && count[i] == 0) {
                taken--;
                ans += i;
            }
        }
        return ans;
    }

    /**
     * 方法二：排序法
     * 先将数组排序，遍历数组，如果当前元素小于等于前一个元素则一直加到比前一个元素大位置，计数加的操作次数
     */

}
