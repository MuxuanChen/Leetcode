package linkedlist;

/**
 * 链表节点
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2020-03-23
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
