package linkedlist;

/**
 * 删除链表的倒数第N个节点
 * <p>
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
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

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummyCode = new ListNode(0, head);
        ListNode prev = dummyCode;
        ListNode cur = dummyCode;
        /**
         * 先走两步
         */
        for (int i = 0; i < n + 1; i++) {
            prev = prev.next;
        }

        /**
         * 等prev走到尾巴处空的时候，cur走到要删除节点的前驱节点
         */
        while (prev != null) {
            prev = prev.next;
            cur = cur.next;
        }

        /**
         * 将要删除节点的前驱节点的next指针指向要删除节点的后驱节点，就实现了删除节点的目的
         */
        cur.next = cur.next.next;
        return dummyCode.next;
    }


    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int x, ListNode node) {
            val = x;
            next = node;
        }
    }
}
