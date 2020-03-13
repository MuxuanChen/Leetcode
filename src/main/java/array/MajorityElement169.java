package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 169.多数元素
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2020-03-13
 */
public class MajorityElement169 {
    /**
     * 投票法
     * 遍历数组，如果当前元素计数为0，假设当前元素就是所求的众数，往后遍历元素如果与所设众数一样，计数+1，否则-1
     * 时间复杂度：O(n)
     */
    public int majorityElement(int[] nums) {
        //要求的众数
        Integer maj = null;
        int count = 0;

        for (int num : nums) {
            if (count == 0){
                maj = num;
            }
           count += (num == maj) ? 1 : -1;
        }

        return maj;
    }


    /**
     * 哈希表
     * 时间复杂度O(n)
     */
    public int majorityElement3(int[] nums) {
        Map<Integer, Integer> num2counts = new HashMap();
        for (int num : nums) {
            Integer count = num2counts.get(num);
            count = count == null ? 0 : count;
            num2counts.put(num, ++count);
            if (count > nums.length / 2){
                return num;
            }
        }
        return -1;
    }

    /**
     * 排序法
     * 排序之后，下标为n/2的值就是解
     * 时间复杂度：O(nlogn)
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
