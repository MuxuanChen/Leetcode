package linkedlist;

/**
 * 两两交换节点
 * <p>
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
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
