package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 *
 * @author Haixiang
 * @email haixiang7c6@gmail.com
 * @since 2020-04-16
 */
public class Merge56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }

        //数组中的元素包含两个元素，用左元素、右元素表示
        //对数组按照左端元素(e[0])排序
        Arrays.sort(intervals, Comparator.comparingInt(e -> e[0]));

        //结果集
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            //当前数组的第一个数比结果数组中最后一个元素的右端元素大，则将当前数组加入结果集
            if (current[0] > res.get(res.size() - 1)[1]) {
                res.add(current);
            } else {
                //扩大结果集中最后一个元素的右元素的值
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], current[1]);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
