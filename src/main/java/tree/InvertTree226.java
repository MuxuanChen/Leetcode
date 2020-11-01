package tree;

/**
 * 翻转二叉树
 *
 * @author Haixiang
 * @email haixiang7c6@gmail.com
 * @since 2020-10-22
 */
public class InvertTree226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
