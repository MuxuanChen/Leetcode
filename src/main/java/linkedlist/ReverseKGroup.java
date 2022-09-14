package linkedlist;

/**
 * K 个一组翻转链表
 * @author Haixiang
 * @since 2022-08-24
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummpy = head;
        int i = 1;
        while(head != null && head.next != null){
            if (i<k){
                ListNode temp = head.next;
                head.next = null;
                temp.next = head;
                head = temp;
                i++;
            }else{
                i = 1;
                head = head.next;
            }
        }
        return dummpy;
    }
}
