package linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * 合并两个排序列表
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2019-01-02
 */
public class MergeTwoSortedLists21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        //如果l1当前节点的值比l2小，则取下一个节点和l2当前节点比，递归
        if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
