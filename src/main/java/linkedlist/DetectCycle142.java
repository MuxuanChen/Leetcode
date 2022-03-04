package linkedlist;

/**
 * 环形链表 II
 *
 * @author Haixiang
 * @since 2022-03-03
 */
public class DetectCycle142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        //从头结点触发
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            //如果有环，头结点走到环入口的步数等于相遇节点走到环入口的步数
            if (fast == slow) {
                ListNode meetIndex = fast;
                ListNode headIndex = head;
                while (meetIndex != headIndex) {
                    meetIndex = meetIndex.next;
                    headIndex = headIndex.next;
                }
                return meetIndex;
            }
        }
        return null;
    }
}
