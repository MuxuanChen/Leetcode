package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Haixiang
 * @email haixiang7c6@gmail.com
 * @since 2020-10-26
 */
public class Flatten114 {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preorderTraversal(root, list);
        //修改链表节点左右子节点
        for (int i = 1; i < list.size(); i++) {
            TreeNode preNode = list.get(i - 1);
            TreeNode current = list.get(i);
            preNode.left = null;
            preNode.right = current;
        }
    }

    /**
     * 前序遍历加入列表
     */
    private void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }
}
