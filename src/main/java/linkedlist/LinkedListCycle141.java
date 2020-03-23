package linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断链表是否有环
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2018-12-23
 */
public class LinkedListCycle141 {
    public boolean hasCycleWithSet(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        if (head == null || head.next == null){
            return false;
        }

        while (head.next != null){
            if (nodes.contains (head)) {
                return true;
            }else{
                nodes.add(head);
                head = head.next;
            }
        }

        return false;

    }


    public boolean hasCycleByTwoPointer(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode quick = head.next;
        ListNode slow = head;
        while (quick != slow){
            if (quick == null || quick.next == null){
                return false;
            }
            quick = quick.next.next;
            slow = slow.next;
        }

        return true;
    }

}
