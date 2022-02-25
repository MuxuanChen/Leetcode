package linkedlist;

/**
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
