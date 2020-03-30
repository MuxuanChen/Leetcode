package recurse;

import linkedlist.ListNode;

/**
 * 面试题62. 圆圈中最后剩下的数字
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2020-03-30
 */
public class LastRemaining62 {

    /**
     * 方法一：数学 + 递归
     * 分析题意：每一次的结果是根据上一次的结果再走m % n得出来的，假设上一次结果为x = f(n-1, m)，
     * 那么这次的结果为f(n) = (m % n + x) % n = (m + x) % n，根据这样的关系写出递归函数。
     */
    public int lastRemaining(int n, int m) {
        return recurse(n, m);
    }

    private int recurse(int n, int m) {
        if (n == 0) {
            return 0;
        }
        int x = recurse(n - 1, m);
        return (x + m) % n;
    }

    /**
     * 方法二：数学 + 循环
     * <p>
     * 最终剩下一个人时的安全位置肯定为0，反推安全位置在人数为n时的编号，每次都是移动m个位置
     * 人数为1： 0
     * 人数为2： (0+m) % 2
     * 人数为3： ((0+m) % 2 + m) % 3
     * 人数为4： (((0+m) % 2 + m) % 3 + m) % 4
     * ........
     * 迭代推理到n就可以得出答案
     */
    public int lastRemaining2(int n, int m) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = (res + m) % i;
        }
        return res;
    }


    /**
     * 在数据量大的时候会超时，通不过LeetCode的检查
     */
    public int lastRemaining_overtime(int n, int m) {
        if (m == 1) {
            return n - 1;
        }
        //构建圆环
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int i = 1; i < n; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
            if (i == n - 1) {
                cur.next = head;
            }
        }

        ListNode guard = new ListNode(-1);
        guard.next = head;
        while (guard.next != guard) {
            for (int i = 0; i < m; i++) {
                if (i == m - 1) {
                    guard.next = guard.next.next;
                } else {
                    guard = guard.next;
                }
            }
        }
        return guard.val;
    }

    public static void main(String[] args) {
        int i = new LastRemaining62().lastRemaining(10, 17);
        System.out.println(i);
    }
}
