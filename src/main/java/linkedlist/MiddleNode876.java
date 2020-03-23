package linkedlist;

/**
 * 876.链表的中间结点
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2020-03-23
 */
public class MiddleNode876 {
    /**
     * 方法一：常规思路单指针计算长度
     * 时间复杂度为O(N),空间复杂度为O(1)
     */
    public ListNode middleNode(ListNode head) {
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        cur = head;
        int middle = count / 2 + 1;
        for (int i = 1; i < middle; i++) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 方法二：双指针
     * 时间复杂度为O(N),空间复杂度为O(1)
     */
    public ListNode middleNode2(ListNode head) {
        ListNode oneStep = head;
        ListNode twoStep = head;
        while (twoStep != null && twoStep.next != null) {
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
        }
        return oneStep;
    }

    /**
     * 方法三：链表转数组
     * 时间复杂度为O(N),空间复杂度为O(N)
     */
    public ListNode middleNode3(ListNode head) {
        ListNode[] nodes = new ListNode[100];
        int index = 0;
        while (head != null) {
            nodes[index++] = head;
        }
        return nodes[index / 2];
    }
}
