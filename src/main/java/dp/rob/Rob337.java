package dp.rob;

import tree.TreeNode;

/**
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 * <p>
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 * <p>
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/house-robber-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author haixiang
 * @since 2022-06-15
 */
public class Rob337 {
    public int rob(TreeNode root) {
        int[] result = recurive(root);
        return Math.max(result[0], result[1]);
    }

    int[] recurive(TreeNode root) {
        int[] result = new int[2];
        if (root == null) {
            return result;
        }
        //0不偷，1偷
        int[] left = recurive(root.left);
        int[] right = recurive(root.right);
        //不偷当前节点，偷子节点
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //偷当前节点，不偷子节点
        result[1] = root.val + left[0] + right[0];
        return result;
    }
}
