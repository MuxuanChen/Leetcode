package tree;

/**
 * 解题思路：要想高度最低，每次取数组的中间元素作为根节点，然后递归左右分支即可。
 *
 * @author Haixiang
 * @email haixiang7c6@gmail.com
 * @since 2020-06-05
 */
public class SortedArrayToBST0402_ms {
    public TreeNode sortedArrayToBST(int[] nums) {
        //边界判断
        if (nums.length < 1) {
            return null;
        }
        return buildTree(nums, 0, nums.length - 1);
    }

    /**
     * 因为要子数组递归用，所以传入left,right两个参数来作为子数组的边界
     */
    private TreeNode buildTree(int[] nums, int left, int right) {
        //结束边界
        if (left > right) {
            return null;
        }
        //获取根节点元素索引
        int middle = (left + right) / 2;
        //递归构建树节点
        TreeNode treeNode = new TreeNode(nums[middle]);
        treeNode.left = buildTree(nums, left, middle - 1);
        treeNode.right = buildTree(nums, middle + 1, right);
        return treeNode;
    }
}
