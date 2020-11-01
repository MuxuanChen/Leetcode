package tree;

/**
 * @author Haixiang
 * @email haixiang7c6@gmail.com
 * @since 2020-10-25
 */
public class SearchBST700 {
    /**
     * 方法一：递归
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
    }

    /**
     * 方法二：迭代
     */
    public TreeNode searchBST2(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = root.val > val ? root.left : root.right;
        }
        return root;
    }

}
