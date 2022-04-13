package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 * @author Haixiang
 * @since 2022-04-12
 */
public class PreorderTraversal144 {

    /**
     * 递归遍历
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

    private void preOrder(TreeNode treeNode, List<Integer> result) {
        if (treeNode == null) {
            return;
        }
        result.add(treeNode.val);
        preOrder(treeNode.left, result);
        preOrder(treeNode.right, result);
    }

    /**
     * 迭代遍历
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        //边界处理
        if (root == null) {
            return result;
        }
        //迭代遍历使用栈
        Stack<TreeNode> stack = new Stack();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            result.add(pop.val);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }

        return result;
    }
}
