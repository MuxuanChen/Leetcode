package queue;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 *
 * @author Haixiang
 * @since 2022-04-11
 */
public class LevelOrder102 {
    public List<List<Integer>> levelOrder(TreeNode root) {

        //最终结果
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        //每一层节点
        Queue<TreeNode> levelNodes = new LinkedList<>();
        levelNodes.offer(root);

        while (!levelNodes.isEmpty()) {
            List<Integer> levelResult = new ArrayList<>();
            //一层的节点数
            int size = levelNodes.size();

            //处理一层节点
            while (size > 0) {
                TreeNode cur = levelNodes.poll();
                levelResult.add(cur.val);

                if (cur.left != null) {
                    levelNodes.add(cur.left);
                }
                if (cur.right != null) {
                    levelNodes.add(cur.right);
                }

                size--;
            }

            result.add(levelResult);
        }

        return result;
    }
}
