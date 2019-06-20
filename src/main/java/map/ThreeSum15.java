package map;


import java.util.*;

/**
 * 三数之和
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2019-06-19
 */
class ThreeSum15 {
    /**
     * 双循环，第三个数放Set
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            // skip same result
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            Set<Integer> requiredNums = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (!requiredNums.contains(nums[j])) {
                    int required = -(nums[i] + nums[j]);
                    requiredNums.add(required);
                } else {
                    List<Integer> group = new ArrayList<>();
                    group.add(nums[i]);
                    group.add(nums[j]);
                    group.add(-(nums[i] + nums[j]));
                    result.add(group);
                }
            }
        }

        return new ArrayList<>(result);
    }

    /**
     * 遍历数组获取第一个数
     * 在第一个数之后的数中，从头尾向中间夹寻找要求的两个数
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        //排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        //遍历数组
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            //左指针
            int j = i + 1;
            //右指针
            int k = nums.length - 1;
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    //去重
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                } else if (nums[j] + nums[k] < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        // int[] arr = {0, 0, 0, 0};
        List<List<Integer>> res = threeSum2(arr);
        System.out.println(res);
    }
}
