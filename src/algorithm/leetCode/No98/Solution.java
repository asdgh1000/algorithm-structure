package algorithm.leetCode.No98;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node2.left = node1;
        node2.right = node3;

        Solution solution = new Solution();
        System.out.println(solution.isValidBST(node2));
    }

    Integer preValue = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        //如果左子树是二叉搜索树再继续搜索右子树，如果不是则直接返回
        if (isValidBST(root.left)) {
            if (preValue != null && preValue >= root.val) {
                return false;
            }
            preValue = root.val;
            return isValidBST(root.right);
        }
        return false;
    }
}