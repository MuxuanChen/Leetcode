package array;

import java.util.Arrays;

/**
 * 912. 排序数组
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2020-03-31
 */
public class SortArray912 {
    /**
     * 方法一：插入排序
     * 对于数据量比较少的情况下用插入排序效率更高
     */
    public int[] sortArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i;
            //暂存当前元素
            int temp = nums[i];
            //比较当前元素和在它之前的元素，直到找到比它小的元素，当前就是它该插入的位置
            while (j > 0 && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
        return nums;
    }

    /**
     * 方法二：直接调用Java类库方法
     */
    public int[] sortArray2(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }

    public static void main(String[] args) {
        int[] vals = {5, 2, 3, 1};
        int[] res = new SortArray912().sortArray(vals);
        System.out.println(Arrays.toString(res));
    }
}
