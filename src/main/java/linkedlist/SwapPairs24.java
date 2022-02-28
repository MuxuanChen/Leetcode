package linkedlist;

/**
 * 两两交换节点
 *
 * @author Haixiang
 * @since 2022-02-28
 */
public class SwapPairs24 {
    public ListNode swapPairs(ListNode head) {
        //虚拟头节点
        ListNode dummyNode = new ListNode(0, head);
        ListNode prev = dummyNode;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode temp = cur.next.next;
            //互换
            prev.next = cur.next;
            cur.next.next = cur;
            cur.next = temp;
            //指针后移
            prev = cur;
            cur = cur.next;
        }
        return dummyNode.next;
    }
}
