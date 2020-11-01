package tree;

/**
 * @author Haixiang
 * @email haixiang7c6@gmail.com
 * @since 2020-11-01
 */
public class LowestCommonAncestor0408 {
    //判断p、q是否在当前节点的左右子树中，如果是，则返回当前节点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        //当前节点的两个子节点刚好是p、q，则当前节点就是要找的节点
        if (root == p || root == q) {
            return root;
        }
        //遍历左子树寻找公共父节点
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        //遍历右子树寻找公共父节点
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        //两个子节点分别在左右子树，说明当前节点就是公共父节点
        if (leftNode != null && rightNode != null) {
            return root;
        }
        //两个子节点都在左子树中，说明左子树返回的公共父节点就是所求的公共父节点
        if (leftNode != null) {
            return leftNode;
        } else {
            //两个子节点都在右子树中，说明左子树返回的公共父节点就是所求的公共父节点
            return rightNode;
        }
    }

}
