package linkedlist;

/**
 * 删除链表的倒数第N个节点
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2019-01-01
 */
public class RemoveNthFromEnd19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //哨兵节点
        ListNode guard = new ListNode(0);
        guard.next = head;
        ListNode first = guard;
        ListNode second = guard;
        for (int i = 0; i < n + 1; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        //当first走到尾节点的时候，second.next就是我们要移除的节点
        second.next = second.next.next;
        return guard.next;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
