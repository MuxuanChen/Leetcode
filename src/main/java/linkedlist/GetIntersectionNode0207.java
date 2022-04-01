package linkedlist;

/**
 * 链表相交
 * <p>
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * <p>
 * A :*--*--*--*--*
 * *              |
 * B:       *--*--*--*--*
 *
 * @author Haixiang
 * @since 2022-03-02
 */
public class GetIntersectionNode0207 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;
        //跑完自己的链表跑对方的链表，如果有交点，就会相遇在交点，如果没有交点，最终都是null
        while (A != B) {
            A = A == null ? headB : A.next;
            B = B == null ? headA : B.next;
        }
        return A;
    }
}
