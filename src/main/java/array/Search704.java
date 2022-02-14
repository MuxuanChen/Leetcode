package array;

/**
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
