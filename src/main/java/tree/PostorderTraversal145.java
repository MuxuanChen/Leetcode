package tree;

import java.util.*;

/**
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 *
 * @author Haixiang
 * @since 2022-04-13
 */
public class PostorderTraversal145 {
    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        postorder(root, result);
        return result;
    }

    public void postorder(TreeNode treeNode, List<Integer> result) {
        if (treeNode == null) {
            return;
        }

        postorder(treeNode.left, result);
        postorder(treeNode.right, result);
        result.add(treeNode.val);
    }

    /**
     * 迭代
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        //边界条件
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        //整个处理顺序为中右左
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            result.add(cur.val);
            //先压入左节点，后处理
            if (cur.left != null) {
                stack.push(cur.left);
            }
            //后压入右节点，先处理
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        //倒序之后会左右中，也就是后序遍历
        Collections.reverse(result);
        return result;
    }

}

