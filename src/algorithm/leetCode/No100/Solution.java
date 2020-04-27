package algorithm.leetCode.No100;

import java.util.List;

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode p = new TreeNode(1);
        TreeNode p1 = new TreeNode(2);
        TreeNode p2 = new TreeNode(1);
        p.left = p1;
        p.right = p2;

        TreeNode q = new TreeNode(1);
        TreeNode q1 = new TreeNode(1);
        TreeNode q2 = new TreeNode(2);
        q.left = q1;
        q.right = q2;
        solution.isSameTree(p, q);
    }
}