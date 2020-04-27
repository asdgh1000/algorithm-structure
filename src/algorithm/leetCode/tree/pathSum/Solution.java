package algorithm.leetCode.tree.pathSum;

/**
 * @author ltw
 * on 2019-10-17.
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        if ((root.left == null) && (root.right == null))
            return ((sum - root.val) == 0);
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

}
