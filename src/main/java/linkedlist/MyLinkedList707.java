package linkedlist;

/**
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Haixiang
 * @since 2022-02-24
 */
public class MyLinkedList707 {
    /**
     * 虚拟头结点
     */
    private ListNode head;
    /**
     * 长度
     */
    private Integer size;

    public MyLinkedList707() {
        head = new ListNode(0);
        size = 0;
    }

    public int get(int index) {
        /**
         * 边界
         */
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode target = head;
        //定位到index节点
        for (int i = 0; i <= index; i++) {
            target = target.next;
        }

        return target.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        /**
         * 边界
         */
        if (index > size || index < 0) {
            return;
        }

        ListNode target = head;
        //定位到index前驱节点
        for (int i = 0; i < index; i++) {
            target = target.next;
        }
        /**
         * 先构建新节点，再挂掉前驱节点上
         */
        ListNode node = new ListNode(val);
        node.next = target.next;
        target.next = node;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode target = head;
        //定位到index前驱节点
        for (int i = 0; i < index; i++) {
            target = target.next;
        }

        /**
         * 定位到目标节点后直接删除
         */
        target.next = target.next.next;

        size--;
    }

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
}
