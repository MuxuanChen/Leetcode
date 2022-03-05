package linkedlist;

/**
 * 环形链表 II
 * <p>
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 不允许修改 链表。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
