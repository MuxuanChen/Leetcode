package linkedlist;

/**
 * 203. 移除链表元素
 *
 * @author Haixiang
 * @since 2022-02-16
 */
public class RemoveElements203 {
    public ListNode removeElements(ListNode head, int val) {
        //边界
        if (head == null) {
            return head;
        }
        //哑结点
        ListNode dummyHead = new ListNode(-1, head);
        //遍历的当前节点
        ListNode currentNode = dummyHead;
        //如果下一个节点不是空
        while (currentNode.next != null) {
            if (currentNode.next.val == val) {
                //删除下一个节点
                currentNode.next = currentNode.next.next;
            } else {
                //走到下一个节点
                currentNode = currentNode.next;
            }
        }
        //返回头节点
        return dummyHead.next;
    }
}
