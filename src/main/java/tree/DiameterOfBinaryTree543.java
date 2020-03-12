package tree;

/**
 * 543.求树的直径
 *
 * 递归公式：每个节点的深度 = max(左子树深度，右子树深度) + 1
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2020-03-10
 */
public class DiameterOfBinaryTree543 {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null){
            return 0;
        }
        //路径上的节点数
        ans = 1;

        dep(root);

        return ans - 1;
    }

    private int dep(TreeNode node) {
        if (node == null){
            return 0;
        }

        int leftDep = dep(node.left);
        int rightDep = dep(node.right);

        //获取较长路径的节点数，当前节点为根节点的路径的节点数 = 左子树 + 右子树 + 根节点
        ans = Math.max(ans, leftDep + rightDep + 1);
        //以该节点为起点的路径经过的节点的最大值即为 L+R+1。
        return Math.max(leftDep, rightDep) + 1;
    }
}
