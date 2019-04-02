package queue;

import java.util.ArrayDeque;
import java.util.Iterator;

/**
 * 最大滑动窗口
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2019-03-11
 */
public class SlidingWindowMaximum239 {
    public static void main(String[] args) {
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length < 1 || k < 1) {
            return new int[0];
        }

        //存窗口里元素的下标
        // int[] window = new int[3];
        ArrayDeque<Integer> window = new ArrayDeque(3);
        //存每次窗口里的最大元素
        int[] result = new int[nums.length - k + 1];

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            //当前窗口里大于3个数，把窗口的第一个数去掉
            if (i >= k && window.peekFirst() <= i - k) {
                window.pop();
            }
            //维护队列，新加入一个元素的时候，移除队列中比自己小的元素
            Iterator<Integer> iterator  = window.iterator();
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                if (nums[next] < nums[i]) {
                    iterator.remove();
                }
            }

            window.add(i);
            if (i >= k - 1) {
                result[index++] = nums[window.peekFirst()];
            }

        }
        return result;
    }
}
