package linkedlist;

/**
 * 链表题目
 *
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2019-12-02
 */
public class ListTopic {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = reverseList(head.next);
        head.next.next = head;
        //去掉原有的指针关系
        head.next = null;
        return result;
    }


    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            //要做的事情
            current.next = prev;
            //维护指针
            prev = current;
            current = next;
        }
        return prev;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode guard = new ListNode(-1);
        ListNode prev = guard;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return guard.next;
    }


    /**
     * 1.双引用从guard开始
     * 2.前一个引用先走n+1步
     * 3.返回guard.next
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode guard = new ListNode(-1);
        ListNode current = guard;
        guard.next = head;
        ListNode nStep = guard;
        for (int i = 0; i <= n; i++) {
            nStep = nStep.next;
        }
        while (nStep != null) {
            nStep = nStep.next;
            current = current.next;
        }
        current.next = current.next.next;
        return guard.next;
    }

    public ListNode middleNode(ListNode head) {
        int t = 0;
        ListNode[] nodes = new ListNode[100];
        while (head != null) {
            nodes[t++] = head;
            head = head.next;
        }
        return nodes[t / 2];
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}