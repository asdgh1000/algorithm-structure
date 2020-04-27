package algorithm.leetCode.interview.No68;

class Solution {
//    p 和 q 在 root 的子树中，且分列 root 的 异侧（即分别在左、右子树中）；
//     p=root ，且 q 在 root 的左或右子树中；
//     q=root ，且 p 在 root 的左或右子树中；

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q); //左子树可能包括 p 或者 q
        TreeNode right = lowestCommonAncestor(root.right, p, q); //右子数可能包括 p 或者q

        if (left == null && right == null) return null;

        if (left == null) return right;
        if (right == null) return left;

        return root;

    }

}