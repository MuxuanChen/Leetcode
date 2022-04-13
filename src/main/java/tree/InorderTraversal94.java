package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 *
 * @author Haixiang
 * @since 2022-04-12
 */
public class InorderTraversal94 {
    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    public void inorder(TreeNode cur, List<Integer> result) {
        if (cur == null) {
            return;
        }

        inorder(cur.left, result);

        result.add(cur.val);

        inorder(cur.right, result);
    }

    /**
     * 迭代
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            //遍历左节点
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                //处理节点，此处得将弹出来的节点赋值给cur指针
                cur = stack.pop();
                result.add(cur.val);
                //加入右节点
                cur = cur.right;
            }
        }
        return result;
    }

}
