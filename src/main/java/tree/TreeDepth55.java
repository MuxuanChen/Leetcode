package tree;

/**
 * @author Haixiang
 * @email haixiang7c6@gmail.com
 * @since 2020-10-18
 */
public class TreeDepth55 {
    int depth = 0;

    /**
     * 本层做的事是计数+1，然后遍历左右子树
     */
    public int maxDepth(TreeNode root) {
        return reduce(root, depth);
    }

    int reduce(TreeNode current, int depth) {
        if (current == null) {
            return depth;
        }
        depth++;
        return Math.max(reduce(current.left, depth), reduce(current.right, depth));
    }


    /**
     * 更简洁，把遍历左右子树和本层做的事合到了一起，更贴近语义
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
