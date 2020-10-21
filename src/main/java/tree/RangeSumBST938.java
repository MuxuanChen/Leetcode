package tree;

/**
 * @author Haixiang
 * @email haixiang7c6@gmail.com
 * @since 2020-10-21
 */
public class RangeSumBST938 {
    int sum = 0;

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        int curVal = root.val;
        if (curVal < L) {
            return rangeSumBST(root.right, L, R);
        }
        if (curVal > R) {
            return rangeSumBST(root.left, L, R);
        }
        sum += curVal;
        rangeSumBST(root.left, L, R);
        rangeSumBST(root.right, L, R);
        return sum;
    }
}
