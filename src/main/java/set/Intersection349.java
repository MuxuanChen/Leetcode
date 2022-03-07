package set;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 *
 * @author Haixiang
 * @since 2022-03-07
 */
public class Intersection349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> num1Set = new HashSet<>();
        for (int i : nums1) {
            num1Set.add(i);
        }
        Set<Integer> resultSet = new HashSet<>();
        for (int i : nums2) {
            if (num1Set.contains(i)) {
                resultSet.add(i);
            }
        }
        int[] result = new int[resultSet.size()];
        int index = 0;
        for (Integer r : resultSet) {
            result[index++] = r;
        }
        return result;
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> num1Set = new HashSet<>();
        for (int i : nums1) {
            num1Set.add(i);
        }
        Set<Integer> num2Set = new HashSet<>();
        for (int i : nums2) {
            num2Set.add(i);
        }
        num1Set.retainAll(num2Set);
        int[] result = new int[num1Set.size()];
        int index = 0;
        for (Integer r : num1Set) {
            result[index++] = r;
        }
        return result;
    }
}
