package linkedlist;

/**
 * 反转链表
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2019-01-03
 */
public class ReverseLinkedList206 {
    public ListNode reverseList(ListNode head) {
       //使用current指针指向当前节点
        ListNode current = head;
        //使用pre指针指向当前节点的前一个节点
        ListNode pre = null;

        while (current != null){
            //取出当前节点的下一个节点
            ListNode next = current.next;
            //修改current指针指向前一个节点
            current.next = pre;
            //将pre指针往后移动
            pre = current;
            //将current指针往后移动
            current = next;
        }
        //最终pre指向新列表的头
        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode temp = null;
        ListNode cur = head;
        ListNode pre = null;

        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    /**
     * 解法三：递归版本
     *
     * @param head
     * @return
     */
    public ListNode reverseList3(ListNode head) {
        return reverse(null, head);
    }

    /**
     * 递归处理一件事：切换链表指针方向
     * 条件：两个参数，两个节点
     *
     * @param pre
     * @param cur
     * @return
     */
    private ListNode reverse(ListNode pre, ListNode cur) {
        if (cur == null) {
            return pre;
        }
        ListNode temp = cur.next;
        cur.next = pre;
        return reverse(cur, temp);
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
