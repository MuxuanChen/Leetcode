package tree;

/**
 * @author Haixiang
 * @email haixiang7c6@gmail.com
 * @since 2020-10-25
 */
public class GetTargetCopy1379 {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return recurse(cloned, target);
    }

    TreeNode recurse(TreeNode cloned, TreeNode target) {
        if (cloned == null) {
            return null;
        }
        if (cloned.val == target.val) {
            return cloned;
        }
        TreeNode left = recurse(cloned.left, target);
        if (left != null) {
            return left;
        }
        TreeNode right = recurse(cloned.right, target);
        if (right != null) {
            return right;
        }
        return null;
    }
}
