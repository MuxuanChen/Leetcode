package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2018-11-22
 */
public class TwoSum1 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++){
            int requiredNum = target - nums[i];
            if (map.containsKey(requiredNum)){
                return new int[]{i,map.get(requiredNum)};
            }
            map.put(nums[i], i);
        }
        throw new RuntimeException("无解");
    }

}
