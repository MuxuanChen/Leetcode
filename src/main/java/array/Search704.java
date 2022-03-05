package array;

/**
 * 二分查找
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Haixiang
 * @since 2022-01-31
 */
public class Search704 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right){//[left,right)
            int middle = left + ((right - left) >> 1);
            if (nums[middle] > target){ //目标值在左半部分
                right = middle;
            }else if (nums[middle] < target){ //目标值在右半部分
                left = middle + 1; //因为左闭右开，所以是middle+1
            }else {
                return middle;//注意这里返回的是数组下标
            }
        }
        return -1;
    }
}
