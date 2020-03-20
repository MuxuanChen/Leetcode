package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 40.最小的k个数
 *
 * 关键点：构建大顶堆
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2020-03-20
 */
public class GetLeastNumbers40 {
    PriorityQueue<Integer> queue;
    private int limit;

    public int[] getLeastNumbers(int[] arr, int k) {
        int[] ans = new int[k];
        if (k == 0) {
            return ans;
        }
        limit = k;
        //构建大顶堆，倒序
        queue = new PriorityQueue<>(k, Comparator.reverseOrder());

        for (int i : arr) {
            add(i);
        }

        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll();
        }
        return ans;
    }

    public int add(int val) {
        if (queue.size() < limit) {
            //加入队列
            queue.offer(val);
        } else if (val < queue.peek()) {
            //取堆顶的元素，队列中最大的元素
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int[] a = {0, 0, 0, 2, 0, 5};
        int[] leastNumbers = new GetLeastNumbers40().getLeastNumbers(a, 0);
        Arrays.stream(leastNumbers).forEach(e -> System.out.println(e));
    }
}
